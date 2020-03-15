package cn.lgq.www.mybatis.sqlsession.impl;

import cn.lgq.www.mybatis.cfg.Configuration;
import cn.lgq.www.mybatis.sqlsession.SqlSession;
import cn.lgq.www.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {
    private Configuration configuration = null;
    public  SqlSessionFactoryImpl(){

    }
    public  SqlSessionFactoryImpl(Configuration configuration){
        this.configuration = configuration;
    }
    /**
     * 用户创建操作数据库的核心对象
     * @return
     */
    public SqlSession openSession() {
        SqlSession sqlSession = new SqlSessionImpl(configuration);
        return sqlSession;
    }
}
