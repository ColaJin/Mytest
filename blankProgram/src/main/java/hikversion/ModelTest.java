package hikversion;

/**
 * @author:jinyandong
 * @description:测试模型比较
 * @Date:2025/1/6
 */
public class ModelTest {
    private String versionNo;

    /*public ModelTest(String s) {
        this.versionNo = s;
    }*/

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public ModelTest(String versionNo) {
        this.versionNo = versionNo;
    }
}
