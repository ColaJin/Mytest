package hikversion;

import org.apache.commons.lang3.StringUtils;
import org.python.core.*;
import org.python.util.PythonInterpreter;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

/**
 * @author:jinyandong
 * @description:测试读取python文件
 * @Date:2021/12/14
 */
public class TestReadPython {
    private static final String FILE_TO = "d:\\test.c";
    public static void main(String[] args) throws IOException {
        /*Process proc;
        try {
            //python.exe处为你系统中python的安装位置；python.py为想要执行的python文件位置；test为想要传的参数
            String arg = "{\n" +
                    "  \"properties\": {\n" +
                    "    \"identifier\": {\n" +
                    "      \"maxLength\": 64,\n" +
                    "      \"title\": \"领域标识符\",\n" +
                    "      \"type\": \"string\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"required\": [\n" +
                    "    \"identifier\"\n" +
                    "  ],\n" +
                    "  \"title\": \"\",\n" +
                    "  \"type\": \"object\"\n" +
                    "}";
            String[] args1 = new String[] { "D:\\environment\\python\\python.exe", "D:\\idea_workplace\\isp\\json_tool\\json_construct.py",arg};
            // proc = Runtime.getRuntime().exec("python.exe python.py "); // 执行py文件 不传参数
            proc=Runtime.getRuntime().exec(args1);

            PythonInterpreter interpreter = new PythonInterpreter();
            interpreter.execfile("D:\\idea_workplace\\isp\\json_tool\\json_construct.py");

            // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
            PyFunction pyFunction = interpreter.get("construct_json_String_to_ccodr", PyFunction.class);
            int a = 5, b = 10;
            //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
            PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
            System.out.println("the anwser is: " + pyobj);
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            File file = new File(FILE_TO);
            copyInputStreamToFile(proc.getInputStream(), file);


            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

//        String arg = "{\n" +
//                "  \"properties\": {\n" +
//                "    \"identifier\": {\n" +
//                "      \"maxLength\": 64,\n" +
//                "      \"title\": \"领域标识符\",\n" +
//                "      \"type\": \"string\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  \"required\": [\n" +
//                "    \"identifier\"\n" +
//                "  ],\n" +
//                "  \"title\": \"\",\n" +
//                "  \"type\": \"object\"\n" +
//                "}";
        String arg = "{\"properties\":{\"identifier\":{\"maxLength\":64,\"title\":\"领域标识符\",\"type\":\"string\"}},\"required\":\"identifier\",\"title\":\"\",\"type\":\"object\"}";

        String arg1 = "{\"items\": {\"properties\": {\"rid\": {\"description\": \"资源描述中的identifier\",\"maxLength\": 64,\"title\": \"资源标识\",\"type\": \"string\",\"validFlag\": 8,\"validResult\": \"NO_VALIDATE\"}}}}";

//         PyObject pyObject= Py.newString(arg);
        PyString strJson=Py.newStringOrUnicode(arg);
        PyString strJson1=Py.newStringOrUnicode(arg1);
        //调用
        // PyObject result=callPythonByJson("D:\\idea_workplace\\isp\\json_tool\\json_construct.py","construct_json_String_to_ccodr",strJson);
         PyObject result=callPythonByJson("D://idea_workplace/Mytest/blankProgram/src/main/java/hikversion/json_construct.py","construct_json_String_to_ccodr",strJson);

        PyObject result1=callPythonByJson("D://idea_workplace/Mytest/blankProgram/src/main/java/hikversion/json_construct.py","construct_json_String_to_ccodr",strJson1);
        System.out.println(result.toString());
        System.out.println(result1.toString());
        string2File(result.toString(),"d:/testJson.h");
        string2File(result1.toString(),"d:/testJson1.h");

        //定义要压缩的文件 也就是说在D盘里有个 demo.txt 的文件(必须要有,否者会有异常,实际应用中可判断);
        List<String> list=new ArrayList<String>();
        list.add("d:/testJson.h");
        list.add("d:/testJson1.h");
        //定义压缩文件的名称
        File zipFile = new File("D:/testJson.zip");
        InputStream input=null;
        //定义压缩输出流
        ZipOutputStream zipOut = null;
        //实例化压缩输出流,并制定压缩文件的输出路径 就是D盘下,名字叫 demo.zip
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        for(String s:list){
            File file = new File(s);
            //定义输入文件流
            input = new FileInputStream(file);
            zipOut.putNextEntry(new ZipEntry(file.getName()));
            //设置注释
            // zipOut.setComment("www.demo.com");
            int temp = 0;
            while((temp = input.read()) != -1) {
                zipOut.write(temp);
            }
            input.close();
        }
        zipOut.close();

    }

    /**
     * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！)
     *
     * @param res  原字符串
     * @param filePath 文件路径
     * @return 成功标记
     */
    public static boolean string2File(String res, String filePath) {
        boolean flag = true;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            File distFile = new File(filePath);
            if (!distFile.getParentFile().exists()) distFile.getParentFile().mkdirs();
            bufferedReader = new BufferedReader(new StringReader(res));
            bufferedWriter = new BufferedWriter(new FileWriter(distFile));
            char buf[] = new char[1024];         //字符缓冲区
            int len;
            while ((len = bufferedReader.read(buf)) != -1) {
                bufferedWriter.write(buf, 0, len);
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            return flag;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public File transferToFile(MultipartFile multipartFile) {
        // 选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            String[] filename = StringUtils.split(originalFilename,".");
            file=File.createTempFile(filename[0], filename[1]);
            multipartFile.transferTo(file);
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;

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
