package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class TestT {
    public void test(Map<String, User> map, List<User> list) {
        System.out.println("有参无返回值方法");
    }

    public Map<String, User> test02() {
        System.out.println("无参有返回值方法");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = TestT.class.getMethod("test", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericExceptionType : genericParameterTypes) {
            System.out.println("genericParameterTypes:" + genericExceptionType);
            if (genericExceptionType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericExceptionType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("actualTypeArgument" + actualTypeArgument);
                }
            }
        }


        System.out.println("====================================");

        method = TestT.class.getMethod("test02", null);
        Type genericReturnType = method.getGenericReturnType();

        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("actualTypeArgument" + actualTypeArgument);
            }
        }
    }
}
