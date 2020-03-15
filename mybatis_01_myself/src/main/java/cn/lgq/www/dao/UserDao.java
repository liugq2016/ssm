package cn.lgq.www.dao;

import cn.lgq.www.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface UserDao {
    /**
     * 查询所有user表的信息的操作
     * @return
     */
    List<User> findAll();
}
