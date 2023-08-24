package hikversion;

/**
 * @author:jinyandong
 * @description:写入文件
 * @Date:2021/12/7
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 二、写出文件
 1、建立联系   File对象  目的地
 2、选择流     文件输出流  OutputStream FileOutputStream
 3、操作  :  write() +flush
 4、释放资源 :关闭
 */
public class WriteFile {
    public static void main(String[] args) {
        String str = "E:/write.h";
        mywrite(str);
    }
    public static void mywrite(String str){
        File file = new File(str);    //1、建立连接
        OutputStream os = null;
        try {
            // 2、选择输出流,以追加形式(在原有内容上追加) 写出文件 必须为true 否则为覆盖
            os = new FileOutputStream(file,true);
            // 和上一句功能一样，BufferedInputStream是增强流，加上之后能提高输出效率，建议
            // os = new BufferedOutputStream(new FileOutputStream(file,true));
            String string = "#include \"cjson_auto_create.h\"\n" +
                    "\n" +
                    "\n" +
                    "/*构造 以下代码为json转换的cjson代码*/\n" +
                    "int auto_create_construct_json_test(cJSON * json_root)\n" +
                    "{\n" +
                    "\tcJSON * js_properties_0 = NULL;\n" +
                    "\tcJSON * js_basic_0 = NULL;\n" +
                    "\tcJSON * js_properties_1 = NULL;\n" +
                    "\tcJSON * js_ipV4Address_1 = NULL;\n" +
                    "\tcJSON * js_ipV6Address_1 = NULL;\n" +
                    "\tcJSON * js_macAddress_1 = NULL;\n" +
                    "\tcJSON * js_dateTime_1 = NULL;\n" +
                    "\tcJSON * js_UUID_1 = NULL;\n" +
                    "\tcJSON * js_optarray_1 = NULL;\n" +
                    "\n" +
                    "\n" +
                    "    CJSON_ADD_ITEM_TO_OBJECT(json_root, \"properties\", js_properties_0);\n" +
                    "    CJSON_ADD_ITEM_TO_OBJECT(js_properties_0, \"basic\", js_basic_0);\n" +
                    "    cJSON_AddStringToObject(js_basic_0, \"description\", \"事件基础信息，所有事件都必须携带，不允许接入设备删改\");\n" +
                    "    CJSON_ADD_ITEM_TO_OBJECT(js_basic_0, \"properties\", js_properties_1);\n" +
                    "    CJSON_ADD_ITEM_TO_OBJECT(js_properties_1, \"ipV4Address\", js_ipV4Address_1);\n" +
                    "    cJSON_AddStringToObject(js_ipV4Address_1, \"default\", \"10.65.101.171\");\n" +
                    "    cJSON_AddStringToObject(js_ipV4Address_1, \"format\", \"ipv4\");\n" +
                    "    cJSON_AddStringToObject(js_ipV4Address_1, \"pattern\", \"\");\n" +
                    "    cJSON_AddStringToObject(js_ipV4Address_1, \"title\", \"设备ipv4地址\");\n" +
                    "    cJSON_AddStringToObject(js_ipV4Address_1, \"type\", \"string\");\n" +
                    "    cJSON_AddStringToObject(js_ipV4Address_1, \"unit\", \"\");\n" +
                    "    CJSON_ADD_ITEM_TO_OBJECT(js_properties_1, \"ipV6Address\", js_ipV6Address_1);\n" +
                    "    cJSON_AddStringToObject(js_ipV6Address_1, \"default\", \"fe80::4883:315d:e4c:75bc\");\n" +
                    "    cJSON_AddStringToObject(js_ipV6Address_1, \"format\", \"ipv6\");\n" +
                    "    cJSON_AddStringToObject(js_ipV6Address_1, \"pattern\", \"\");\n" +
                    "    cJSON_AddStringToObject(js_ipV6Address_1, \"title\", \"设备ipv6地址\");\n" +
                    "    cJSON_AddStringToObject(js_ipV6Address_1, \"type\", \"string\");\n" +
                    "    cJSON_AddStringToObject(js_ipV6Address_1, \"unit\", \"\");\n" +
                    "    CJSON_ADD_ITEM_TO_OBJECT(js_properties_1, \"macAddress\", js_macAddress_1);\n" +
                    "    cJSON_AddStringToObject(js_macAddress_1, \"default\", \"0C-9D-92-99-DD-31\");\n" +
                    "    cJSON_AddStringToObject(js_macAddress_1, \"format\", \"\");\n" +
                    "    cJSON_AddNumberToObject(js_macAddress_1, \"maxLength\", 17);\n" +
                    "    cJSON_AddNumberToObject(js_macAddress_1, \"minLength\", 17);\n" +
                    "    cJSON_AddStringToObject(js_macAddress_1, \"pattern\", \"\");\n" +
                    "    cJSON_AddStringToObject(js_macAddress_1, \"title\", \"设备MAC地址\");\n" +
                    "    cJSON_AddStringToObject(js_macAddress_1, \"type\", \"string\");\n" +
                    "    cJSON_AddStringToObject(js_macAddress_1, \"unit\", \"\");\n" +
                    "    CJSON_ADD_ITEM_TO_OBJECT(js_properties_1, \"dateTime\", js_dateTime_1);\n" +
                    "    cJSON_AddStringToObject(js_dateTime_1, \"default\", \"2021-01-28T02:00:00+08:00\");\n" +
                    "    cJSON_AddStringToObject(js_dateTime_1, \"format\", \"date-time\");\n" +
                    "    cJSON_AddStringToObject(js_dateTime_1, \"pattern\", \"\");\n" +
                    "    cJSON_AddStringToObject(js_dateTime_1, \"title\", \"时间\");\n" +
                    "    cJSON_AddStringToObject(js_dateTime_1, \"type\", \"string\");\n" +
                    "    cJSON_AddStringToObject(js_dateTime_1, \"unit\", \"\");\n" +
                    "    CJSON_ADD_ITEM_TO_OBJECT(js_properties_1, \"UUID\", js_UUID_1);\n" +
                    "    cJSON_AddStringToObject(js_UUID_1, \"default\", \"079f23cd-0988-459f-96f5-fa1c507dd07c\");\n" +
                    "    cJSON_AddStringToObject(js_UUID_1, \"format\", \"\");\n" +
                    "    cJSON_AddNumberToObject(js_UUID_1, \"maxLength\", 64);\n" +
                    "    cJSON_AddNumberToObject(js_UUID_1, \"minLength\", 0);\n" +
                    "    cJSON_AddStringToObject(js_UUID_1, \"pattern\", \"\");\n" +
                    "    cJSON_AddStringToObject(js_UUID_1, \"title\", \"上传事件唯一标识\");\n" +
                    "    cJSON_AddStringToObject(js_UUID_1, \"type\", \"string\");\n" +
                    "    cJSON_AddStringToObject(js_UUID_1, \"unit\", \"\");\n" +
                    "    CJSON_CREATE_ARRAY(js_optarray_1);\n" +
                    "    cJSON_AddItemToObject(js_basic_0, \"required\", js_optarray_1);\n" +
                    "    cJSON_AddItemToArray(js_optarray_1, cJSON_CreateString(\"dateTime\"));\n" +
                    "    cJSON_AddItemToArray(js_optarray_1, cJSON_CreateString(\"UUID\"));\n" +
                    "    cJSON_AddStringToObject(js_basic_0, \"title\", \"事件基础信息\");\n" +
                    "    cJSON_AddStringToObject(js_basic_0, \"type\", \"object\");\n" +
                    "    cJSON_AddStringToObject(json_root, \"title\", \"\");\n" +
                    "    cJSON_AddStringToObject(json_root, \"type\", \"object\");\n" +
                    "\treturn COMBSTA_OK;\n" +
                    "}\n" +
                    "/*end*/\n" +
                    "\n" +
                    "成功!!!\n";
            byte[] data = string.getBytes();    //将字符串转换为字节数组,方便下面写入

            os.write(data, 0, data.length);    //3、写入文件
            os.flush();    //将存储在管道中的数据强制刷新出去
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没有找到！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写入文件失败！");
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输出流失败！");
                }
            }
        }
    }
}
