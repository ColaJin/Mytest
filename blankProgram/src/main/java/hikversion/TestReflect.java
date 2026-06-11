package hikversion;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author:jinyandong
 * @description:测试反射
 * @Date:2025/1/8
 */
public class TestReflect {
    public static void main(String[] args) {
        /*ModelTest modelTest = new ModelTest("1.2.0");
        Class sourceClass = modelTest.getClass();
        Field[] declaredFields = sourceClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            System.out.println("declaredField.getName() :" + name);
            declaredField.setAccessible(true);
            try {
                Object value = declaredField.get(modelTest);
                System.out.println("declaredField.get() :" + JSONObject.toJSONString(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }*/
        DeviceTest deviceTest = new DeviceTest();
        deviceTest.setStatus(1);
        Class sourceClass = deviceTest.getClass();
        // status:Field
        Map<String, Field> fields = Arrays.stream(sourceClass.getDeclaredFields()).collect(Collectors.toMap(Field::getName, f -> f));
        // setStatus:Method
        Map<String, Method> Methods = Arrays.stream(sourceClass.getMethods()).collect(Collectors.toMap(Method::getName, m -> m, (m1, m2) ->
                m2.getParameterCount() == 1 ? m2 : m1
        ));

        // key：status，option是EXACT，value是1

        Field field = fields.get("status");
        // org.apache.commons.lang3.StringUtils capitalize大写第一个字母
        Method method = Methods.get("set" + StringUtils.capitalize("status"));
        // 定义在构建查询时需要忽略的属性路径
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id");
        // StringMatcher EXACT表示匹配精准的字符串
        if (field != null && method != null) {
            if (method.getParameterCount() != 1) {
                return;
            }
            Class c = method.getParameterTypes()[0];

            try {
                method.invoke(deviceTest, 1);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

            }
            // 匹配字符串模式
            ExampleMatcher.StringMatcher stringMatcher = Enum.valueOf(ExampleMatcher.StringMatcher.class, "EXACT");
            matcher = matcher.withMatcher("status", ExampleMatcher.GenericPropertyMatcher.of(stringMatcher));
        }
        //Example<T> example = Example.of(deviceTest, matcher);

    }
}
