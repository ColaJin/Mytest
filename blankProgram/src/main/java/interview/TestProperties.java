package interview;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 * @author:jinyandong
 * @description:Properties属性集
 * @Date:2023/12/8
 */
public class TestProperties {
    // 用来对键值对数据进行读写操作
    public static void main(String[] args) {
        try {
            Properties pro = new Properties();
            pro.setProperty("name", "jyd");
            FileWriter writer = new FileWriter("d:/s.properties");
            // 用来解释保存说明 用来干什么用的（不能使用中文，会产生乱码）
            pro.store(writer, "comments");
            System.out.println("write success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 创建Properties属性集合
            Properties pro = new Properties();

            FileReader reader = new FileReader("d:/s.properties");
            // 从文件中读取内容加载在内存中
            pro.load(reader);
            String name = pro.getProperty("name");
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
