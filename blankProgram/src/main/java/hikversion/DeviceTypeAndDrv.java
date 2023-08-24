package hikversion;

/**
 * @author:jinyandong
 * @description:驱动设备模型关系
 * @Date:2021/8/14
 */
public class DeviceTypeAndDrv {
    private String drvId;
    private String drvVersion;

    public String getDrvId() {
        return drvId;
    }

    public void setDrvId(String drvId) {
        this.drvId = drvId;
    }

    public String getDrvVersion() {
        return drvVersion;
    }

    public void setDrvVersion(String drvVersion) {
        this.drvVersion = drvVersion;
    }
}
