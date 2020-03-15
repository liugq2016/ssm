package cn.lgq.www.mybatis.proxy;

import cn.lgq.www.domain.User;
import cn.lgq.www.mybatis.cfg.Mapper;
import cn.lgq.www.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.UnknownServiceException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String,Mapper> mappers = null;
    private Connection conn = null;

    /**
     * 无参构造函数
     */
    public MapperProxy(){

    }

    /**
     * 有参构造函数
     * @param mappers
     */
    public MapperProxy( Map<String,Mapper> mappers ,Connection conn){
            this.mappers = mappers;
            this.conn = conn;
    }
    /**
     * 对方法进行增强
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        1. 获取方法名
        String methodname = method.getName();
//        2.获取方法所在类的名称
        String classname = method.getDeclaringClass().getName();
//        3.组合key
        String key = classname + "." + methodname;
//        4.获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
//        5.判断是否有mapper
        if (mapper == null){
//            mapper无值
            throw new IllegalArgumentException("传入参数有误");
        }
//        6.调用工具类执行查询所有
        List<?> objects = new Executor().selectList(mapper, conn);
        return objects;
    }
}
