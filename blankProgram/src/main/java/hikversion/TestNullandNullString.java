package hikversion;

/**
 * @author:jinyandong
 * @description:测试空字符串是否是空
 * @Date:2022/9/6
 */
public class TestNullandNullString {
    public static void main(String[] args) {
        DeviceTypeAndSoftwareVersion deviceTypeAndSoftwareVersion = new DeviceTypeAndSoftwareVersion("","");
        if (deviceTypeAndSoftwareVersion.getDeviceType() == null) {
            System.out.println("\"\" equal null");
        }
    }
}
