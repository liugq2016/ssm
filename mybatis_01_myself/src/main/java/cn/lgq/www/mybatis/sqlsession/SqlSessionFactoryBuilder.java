package cn.lgq.www.mybatis.sqlsession;

import cn.lgq.www.mybatis.cfg.Configuration;
import cn.lgq.www.mybatis.sqlsession.impl.SqlSessionFactoryImpl;
import cn.lgq.www.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author lgq
 * 用于创建sqlsessionfactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param is
     * @return
     */
    public SqlSessionFactory build(InputStream is){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(is);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryImpl(cfg);
        return sqlSessionFactory;
    }
}
