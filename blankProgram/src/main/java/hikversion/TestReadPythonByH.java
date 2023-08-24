package hikversion;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author:jinyandong
 * @description:测试读取python文件：此方式会执行main方法需要注释掉main方法
 * @Date:2021/12/14
 */
public class TestReadPythonByH {
    // 此方式会执行main方法需要注释掉main方法
    public static void main(String[] args) throws IOException {

        String str = "{\"domains\":[\"DynamicCapability\",\"DynamicResource\"]}";
        // 1. Python面向函数式编程: 在Java中调用Python函数
        String pythonFunc = "D://idea_workplace/Mytest/blankProgram/src/main/java/hikversion/json_construct.py";
        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter pi1 = new PythonInterpreter();
        // 加载python程序
        pi1.execfile(pythonFunc);
        // 调用Python程序中的函数
        PyFunction pyf = pi1.get("construct_json_String_to_ccodr", PyFunction.class);
        // 模拟参数
        /*Map<String,Object> params = new HashMap<>();
        params.put("name","tom");
        params.put("age",18);*/
        JSONObject js = new JSONObject();
        List<String> list = new ArrayList<>();
        list.add("DynamicCapability");
        list.add("DynamicResource");
        JSONObject.toJSONString(list);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("DynamicCapability");
        jsonArray.add("DynamicResource");
        // js.put("domains", jsonArray);
        js.put("domains", list);
        // js.put("domains", JSONObject.toJSONString(list));
        String result = JSONObject.toJSONString(js);
        // PyObject dddRes = pyf.__call__(new PyString(str));
        PyObject dddRes = pyf.__call__(new PyString(result));
        System.out.println(dddRes);
        pi1.cleanup();
        pi1.close();
    }

}
