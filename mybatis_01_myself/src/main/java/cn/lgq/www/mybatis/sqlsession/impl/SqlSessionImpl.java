package cn.lgq.www.mybatis.sqlsession.impl;

import cn.lgq.www.domain.User;
import cn.lgq.www.mybatis.cfg.Configuration;
import cn.lgq.www.mybatis.proxy.MapperProxy;
import cn.lgq.www.mybatis.sqlsession.SqlSession;
import cn.lgq.www.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlSessionImpl implements SqlSession {
    private Configuration configuration = null;
    private Connection conn = null;

    public SqlSessionImpl(){

    }
    public SqlSessionImpl(Configuration configuration){
        this.configuration = configuration;
        this.conn = DataSourceUtil.getConnection(configuration);
    }
    /**
     * 创建代理对象
     * @param daoInterfaceClass dao的接口字节码文件
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        T t  = (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MapperProxy(configuration.getMappers(), conn));
        return t;
    }

    /**
     * 释放资源
     */
    public void close() {

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
