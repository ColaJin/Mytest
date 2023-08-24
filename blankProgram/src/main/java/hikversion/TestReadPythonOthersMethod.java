package hikversion;

import org.apache.commons.lang3.StringUtils;
import org.python.core.*;
import org.python.util.PythonInterpreter;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author:jinyandong
 * @description:测试读取python文件
 * @Date:2021/12/14
 */
public class TestReadPythonOthersMethod {
    public static void main(String[] args) {
        try {
            //python.exe处为你系统中python的安装位置；python.py为想要执行的python文件位置；test为想要传的参数
            String arg = "{\"domains\":[\"DynamicCapability\",\"DynamicResource\"]}";
            /*String[] args1 = new String[] { "D:\\environment\\python\\python.exe", "D://idea_workplace/Mytest/blankProgram/src/main/java/hikversion/json_construct.py",arg};

            Process pr=Runtime.getRuntime().exec(args1);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");*/

            PyString strJson=Py.newStringOrUnicode(arg);
            //调用
            PyObject result=callPythonByJson("D://idea_workplace/Mytest/blankProgram/src/main/java/hikversion/json_construct.py","construct_json_String_to_ccodr",strJson);

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 调用python
     *
     * @param fileUrl  python文件路径
     * @param method   执行的python函数
     * @param pyObject json参数
     *
     */
    public static PyObject callPythonByJson(String fileUrl, String method, PyObject pyObject){
        if(method.trim().equals("")){
            return null;
        }
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(fileUrl);
        // 第一个参数为期望获得的函数的名字，第二个参数为期望返回的对象类型
        PyFunction pyFunction = interpreter.get(method, PyFunction.class);
        PyObject res=pyFunction.__call__(pyObject);
        interpreter.close();
        return res;
    }
}
