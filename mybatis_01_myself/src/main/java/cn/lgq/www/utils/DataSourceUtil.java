package cn.lgq.www.utils;

import cn.lgq.www.mybatis.cfg.Configuration;
import sun.security.krb5.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 创建数据源的工具类
 */

public class DataSourceUtil {

    /**
     * 获取连接对象
     * @param configuration
     * @return
     */
    public static Connection getConnection(Configuration configuration){
        Connection connection = null;
        try {
            Class.forName(configuration.getDriver());
             connection = DriverManager.getConnection(configuration.getUrl(),
                    configuration.getUsername(),
                    configuration.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }


}
