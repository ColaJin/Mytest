package hikversion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

/**
 * @author:jinyandong
 * @description:测试生成Bmp文件
 * @Date:2023/11/13
 */
public class TestBmpCopy {
    public static void main(String args[]) throws Exception {
        // 设备端返回的Bse64加密的字符串信息
        String str = "Qk2iBwAAAAAAADYAAAAoAAAAGQAAABkAAAABABgAAAAAAGwHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA////////////////xMTEAAAAxMTE////////////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP///////////////8TExAAAAMTExP///////////////wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD////////////////ExMQAAADExMT///////////////8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA////////////////xMTEAAAAxMTE////////////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAP///7+/vzg4OENDQwAAAAAAAAAAAP///////////////8TExAAAAMTExP///////////////wAAAAAAAAAAAENDQzg4OL+/v////wCLi4v///////////+EhIQzMzMAAAD////////////////W1tYAAADW1tb///////////////8AAABKSkqCgoL///////////+Li4sAAAAANjY2Ghoa////////8fHx29vbISEhLy8vKysrKysrHx8fAAAAHx8fLCwsKSkpKSkpHx8f39/f////////////GhoaNjY2AAAAAAAAAAAAAAAAAAAAAEdHR/Dw8P///wEBAQAAABYWFhsbGxUVFRsbGxYWFhMTExMTExMTEwQEBP///3l5eQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADLy8v///8fHx9gYGD////////////////////////////////R0dEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAzs7O////+Pj4EREROzs7////////////////////////////zc3NAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM7Ozv///////////wICAkNDQ////////////////////////87OzgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADOzs7///////////////8AAAA/Pz/////////////////////Ozs4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAzs7O////////////////+vr6EhISPj4+////////////////zs7OAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM7Ozv////////////////////r6+gAAAERERP///////////87OzgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADOzs7///////////////////////////8AAAA/Pz/////////Ozs4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAzs7O////////////////////////////////JCQkU1NT////4uLiAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOLi4v///////6GhoVhYWEdHR0dHR0dHR2dnZ0tLSwAAAE1NTVVVVQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD///+4uLgAAAAAAADt7e3W1tbt7e0AAAAAAACQkJD39/cAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAwMD////////////////////AAAAcXFx/////Pz8GhoaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACIiIufn5////////////////////+fn5wYGBmVlZf///9jY2BMTEwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABpaWn///////////////////////////9oaGgAAAD////////q6uoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAZmZm////////////////////////////ZmZmAAAAMTEx////////8fHxCAgIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD09Pfz8/P////////////////////z8/D09PQAAAAAAADs7O////////8TExAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAvLy////////////////////8vLy8AAAAAAAAAAAAAAAA4ODj////q6uo2NjYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFBQU////////////FBQUAAAAAAAAAAAAAAAAAAAAAAAAKSkp////cnJyAAAAAA==";
        uploadFileToLocal(str);
    }

    /**
     * 根据设备端返回的数据转换成的字符串生成bmp文件
     *
     * @param str：设备端返回的base64加密的字节数组
     * @throws Exception
     */
    public static void uploadFileToLocal(String str) throws Exception {
        byte[] decode = Base64.getDecoder().decode(str);
        InputStream inputStream = new ByteArrayInputStream(decode);
        try {
            BufferedImage image = ImageIO.read(inputStream);
            // 文件生成路径
            File output = new File("D:\\b.bmp");
            if (output.exists()) {
                output.delete();
            }
            ImageIO.write(image, "bmp", output);
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            inputStream.close();
        }
    }

}
