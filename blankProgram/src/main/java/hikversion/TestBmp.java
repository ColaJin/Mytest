package hikversion;

import com.sun.imageio.plugins.common.ImageUtil;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

/**
 * @author:jinyandong
 * @description:测试生成Bmp文件
 * @Date:2023/11/13
 */
public class TestBmp {
    public static void main(String args[]) throws Exception {
        /*int width=100;
        int height=100;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        File file=new File("example.bmp");
        ImageIO.write(image, "bmp", file);*/

        String filePath = "play/00.bmp";
        if (StringUtils.contains(filePath, "icon")) {
            System.out.println("contains");
        }

        //String str = dealBmpFile();
        String str = dealBmpString();
        uploadFileToLocal(str);
        // getBmpFile();
    }

    /*public static String uploadFileToLocal( String path, String fileName) throws Exception {
        try {
            File folder = new File(path);
            // 创建没有的文件夹
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }
            //创建空文件
            FileOutputStream outputStream = new FileOutputStream(path + "/" + fileName);
            // 将文件流数据填充到空文件
            int index = 0;
            String str = "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";
            byte[] decode = Base64.getDecoder().decode(str);
            InputStream input = new ByteArrayInputStream(decode);
            while ((index = input.read(decode)) != -1) {
                outputStream.write(decode, 0, index);
                outputStream.flush();
            }
            input.close();
            outputStream.close();
            return path + "/" + fileName;
        } catch (Exception e) {
            return "【报错】" + e.getMessage();
        }
    }*/

    /**
     *
     *
     * @param str
     * @throws Exception
     */
    public static void uploadFileToLocal(String str) throws Exception {
        /*byte[] bytes = new byte[]{0x31,0x32};
        String tempStr = new String(bytes, "GBK");
        System.out.println(Base64.getEncoder().encodeToString(tempStr.getBytes("GBK")));
        System.out.println(Base64.getEncoder().encodeToString(bytes));*/
        byte[] decode = Base64.getDecoder().decode(str);
        /*byte[] decode1 = Base64.getDecoder().decode(new String(str.getBytes(),"GBK"));
        String old = new String(decode,"GBK");
        String old1 = new String(decode1,"GBK");
        System.out.println(old);
        System.out.println(old1);*/
        // byte[] tempByte = str.getBytes("GBK");
        // byte[] info = Base64.getDecoder().decode(str.getBytes("GBK"));
        //byte[] info = Base64.getDecoder().decode(old.getBytes());
        InputStream inputStream = new ByteArrayInputStream(decode);
        try {
            BufferedImage image = ImageIO.read(inputStream);
            File output = new File("D:\\b.bmp");
            // 创建没有的文件夹
            if (output.exists()) {
                output.delete();
            }
            ImageIO.write(image,"bmp",output);
        } catch (Exception e) {
            System.out.println("error");
        }finally {
            inputStream.close();
        }
    }

    public static String dealBmpFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/000.bmp");
        int readLength = 4096;
        byte[] valiMsg = null;
        int readed = 0;
        //IO读取
        byte[] bufData = new byte[readLength];
        if ((readed = fileInputStream.read(bufData)) > 0) {
            valiMsg = new byte[readed];
        }
        System.arraycopy(bufData, 0, valiMsg, 0, readed);

        String tempStr = new String(valiMsg, "GBK");
        System.out.println(tempStr);
        String fileDetail = Base64.getEncoder().encodeToString(tempStr.getBytes("GBK"));
        return fileDetail;
        //return Base64.getEncoder().encodeToString(valiMsg);
    }
    public static String dealBmpString() throws IOException {
        String str ="Qk2iBwAAAAAAADYAAAAoAAAAGQAAABkAAAABABgAAAAAAGwHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA////////////////xMTEAAAAxMTE////////////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP///////////////8TExAAAAMTExP///////////////wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD////////////////ExMQAAADExMT///////////////8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA////////////////xMTEAAAAxMTE////////////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAP///7+/vzg4OENDQwAAAAAAAAAAAP///////////////8TExAAAAMTExP///////////////wAAAAAAAAAAAENDQzg4OL+/v////wCLi4v///////////+EhIQzMzMAAAD////////////////W1tYAAADW1tb///////////////8AAABKSkqCgoL///////////+Li4sAAAAANjY2Ghoa////////8fHx29vbISEhLy8vKysrKysrHx8fAAAAHx8fLCwsKSkpKSkpHx8f39/f////////////GhoaNjY2AAAAAAAAAAAAAAAAAAAAAEdHR/Dw8P///wEBAQAAABYWFhsbGxUVFRsbGxYWFhMTExMTExMTEwQEBP///3l5eQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADLy8v///8fHx9gYGD////////////////////////////////R0dEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAzs7O////+Pj4EREROzs7////////////////////////////zc3NAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM7Ozv///////////wICAkNDQ////////////////////////87OzgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADOzs7///////////////8AAAA/Pz/////////////////////Ozs4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAzs7O////////////////+vr6EhISPj4+////////////////zs7OAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM7Ozv////////////////////r6+gAAAERERP///////////87OzgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADOzs7///////////////////////////8AAAA/Pz/////////Ozs4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAzs7O////////////////////////////////JCQkU1NT////4uLiAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOLi4v///////6GhoVhYWEdHR0dHR0dHR2dnZ0tLSwAAAE1NTVVVVQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD///+4uLgAAAAAAADt7e3W1tbt7e0AAAAAAACQkJD39/cAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAwMD////////////////////AAAAcXFx/////Pz8GhoaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACIiIufn5////////////////////+fn5wYGBmVlZf///9jY2BMTEwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABpaWn///////////////////////////9oaGgAAAD////////q6uoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAZmZm////////////////////////////ZmZmAAAAMTEx////////8fHxCAgIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD09Pfz8/P////////////////////z8/D09PQAAAAAAADs7O////////8TExAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAvLy////////////////////8vLy8AAAAAAAAAAAAAAAA4ODj////q6uo2NjYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFBQU////////////FBQUAAAAAAAAAAAAAAAAAAAAAAAAKSkp////cnJyAAAAAA==";
        System.out.println(str);
        return str;
    }

}
