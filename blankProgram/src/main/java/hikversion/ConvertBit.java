package hikversion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:jinyandong
 * @description:转换二进制编码
 * @Date:2021/9/30
 */
public class ConvertBit {
    public static void main(String[] args) throws IOException {

        File file = new File("E:\\hikvision\\物联网接入项目\\问题\\210928\\test.bin");

        try {
            InputStream fileIn = new FileInputStream(file);
            //DataInputStream in = new DataInputStream(fileIn);

            // 使用缓存区读入对象效率更快
            BufferedInputStream in = new BufferedInputStream(fileIn);


            // 使用缓存区写入对象效率更快
            //BufferedOutputStream dataOut=new BufferedOutputStream(fileOut);
            int temp;
            while ((temp = in.read()) != -1) {
                System.out.println(temp);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
