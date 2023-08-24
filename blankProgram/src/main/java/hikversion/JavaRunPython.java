package hikversion;

import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author:jinyandong
 * @description:java文件调用python脚本
 * @Date:2021/12/6
 */
public class JavaRunPython {
    public static void main(String[] args) {
        // 测试
        /*PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("a='hello world'; ");
        interpreter.exec("print a;");*/
        // 传参调用
        /*try {
            String arg = "{\n" +
                    "  \"properties\": {\n" +
                    "    \"heartbeatPeriod\": {\n" +
                    "      \"maximum\": 100,\n" +
                    "      \"minimum\": 0,\n" +
                    "      \"title\": \"心跳周期\",\n" +
                    "      \"type\": \"number\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"required\": [],\n" +
                    "  \"title\": \"\",\n" +
                    "  \"type\": \"object\"\n" +
                    "}";
            String[] myArgs = new String[] { "python", "E:\\json_tool\\main.py", arg };
            // CreateProcess error=193, %1 不是有效的 Win32 应用程序报错。需要用python命令执行
            Process pr = Runtime.getRuntime().exec(myArgs);
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


    private static void writeToLocal(String destination, InputStream input) throws Exception {
        int index;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream(destination);
        while ((index = input.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        downloadFile.close();
        input.close();
    }
}
