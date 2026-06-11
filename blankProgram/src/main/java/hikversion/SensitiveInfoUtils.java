package hikversion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.ValueFilter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:敏感信息打印
 * @Date:2024/7/29
 */
public class SensitiveInfoUtils {
    private static Set<String> filterSet = new HashSet<>();
    static {
        filterSet.add("AES-param");
        filterSet.add("AES-supports");

    }

    // 使用 SensitiveInfoUtils.toStringObject(paramMap)
    public static String toStringObject(Object object) {
        return JSON.toJSONString(object, getPropertyFilter());
    }

    // 类字段增加注解 @SensitiveInfo(type = SensitiveType.SENSITIVE)
    // 使用SensitiveInfoUtils.toStringAno(message)
    public static String toStringAno(Object object) {
        return JSON.toJSONString(object, getValueFilter());
    }

    private static final PropertyFilter getPropertyFilter() {
        PropertyFilter filter = new PropertyFilter() {
            // name：属性名称，value：属性值
            public boolean apply(Object source, String name, Object value) {
                if (filterSet.contains(name)) {
                    // true 需要序列化，过滤出来
                    return true;
                }
                // false 无需序列化，不过滤出来
                return false;
            }
        };
        return filter;
    }

    public static final ValueFilter getValueFilter() {
        return new ValueFilter() {
            @Override
            public Object process(Object obj, String key, Object value) {//obj-对象  key-字段名  value-字段值
                if(obj instanceof Map || obj instanceof JSONObject){
                    if("password".equals(key) && StringUtils.isNotEmpty((String)value)){
                        return "******";
                    }
                    if("deviceSecretKey".equals(key) && StringUtils.isNotEmpty((String)value)){
                        return "******";
                    }
                }
                try {
                    Field field = obj.getClass().getDeclaredField(key);
                    SensitiveInfo annotation = field.getAnnotation(SensitiveInfo.class);
                    if (null != annotation) {
                        switch (annotation.type()) {
                            case SENSITIVE:
                                return "******";

                            default:
                                break;
                        }
                    }
                } catch (NoSuchFieldException e) {
                    //找不到的field对功能没有影响,空处理
                }
                return value;
            }
        };
    }
}
