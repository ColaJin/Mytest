package com;

import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
@PropertySource("classpath:jdbc.properties")
public class PropertiesTest {
    //Propertites:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties properties = new Properties();
            //报错系统找不到指定文件，需要把配置文件放在项目下，也就是Mytest文件夹下
            fis = new FileInputStream("jdbc.properties");
            properties.load(fis);
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name = "+ name+",passoword = "+ password);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
