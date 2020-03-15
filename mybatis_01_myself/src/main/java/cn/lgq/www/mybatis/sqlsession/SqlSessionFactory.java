package cn.lgq.www.mybatis.sqlsession;

public interface SqlSessionFactory {
    /**
     * 用户创建sqlsession对象
     * @return
     */
    SqlSession openSession();
}
