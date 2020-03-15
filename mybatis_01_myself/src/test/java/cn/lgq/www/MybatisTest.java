package cn.lgq.www;

import cn.lgq.www.dao.UserDao;
import cn.lgq.www.domain.User;
import cn.lgq.www.mybatis.io.Resources;
import cn.lgq.www.mybatis.sqlsession.SqlSession;
import cn.lgq.www.mybatis.sqlsession.SqlSessionFactory;
import cn.lgq.www.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws IOException {
    //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建 SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =sqlSessionFactoryBuilder.build(is);
     //使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用SqlSession创建Dao接口的代理对象
        UserDao userdao_Proxy = sqlSession.getMapper(UserDao.class);
        //使用代理对象执行方法
        List<User> users = userdao_Proxy.findAll();
        for (User user:users) {
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
        is.close();
    }
}
