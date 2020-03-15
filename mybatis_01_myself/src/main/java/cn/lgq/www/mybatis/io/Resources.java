package cn.lgq.www.mybatis.io;

import java.io.InputStream;

/**
 * @author lgq
 * @company www.lgq.cn
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据文件路径获取文件输入流
     * @param filepath
     * @return
     */
   public static InputStream getResourceAsStream(String filepath){
       InputStream is = null;
       try {
           is = Resources.class.getClassLoader().getResourceAsStream(filepath);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return is;
    }
}
