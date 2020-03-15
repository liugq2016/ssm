package cn.lgq.www.mybatis.sqlsession;

/**
 * @author lgq
 * mybatis中与数据库交互的核心类，它可以创建dao接口的代理对象
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码文件
     * @param <T>
     * @return
     */
  <T>  T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
  void close();
}
