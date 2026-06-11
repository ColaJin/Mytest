package hikversion;

/**
 * @author:jinyandong
 * @description:测试
 * @Date:2025/1/21
 */
public class ClusterUtils {
    public static DacException ErrorWithCode(String code) {
        DacException e1 = new DacException("dac 异常", code);
        return e1;
    }
}
