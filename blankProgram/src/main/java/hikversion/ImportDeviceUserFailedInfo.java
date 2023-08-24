package hikversion;


/**
 * 导入设备关联权限返回结果
 */
public class ImportDeviceUserFailedInfo {

    private String row;

    private String col;

    private String username;

    private String deviceIndexCode;

    private String code;

    private String msg;

    public ImportDeviceUserFailedInfo(String row, String code, String msg) {
        this.row = row;
        this.code = code;
        this.msg = msg;
    }

    public ImportDeviceUserFailedInfo(String row, String msg) {
        this.row = row;
        this.msg = msg;
    }

    public ImportDeviceUserFailedInfo(String row, String username, String deviceIndexCode, String code, String msg) {
        this.row = row;
        this.deviceIndexCode = deviceIndexCode;
        this.username = username;
        this.code = code;
        this.msg = msg;
    }

    public ImportDeviceUserFailedInfo(String row, String col, String username, String deviceIndexCode, String code, String msg) {
        this.row = row;
        this.col = col;
        this.username = username;
        this.deviceIndexCode = deviceIndexCode;
        this.code = code;
        this.msg = msg;
    }

    public ImportDeviceUserFailedInfo(String row, String col, String code, String msg) {
        this.row = row;
        this.col = col;
        this.code = code;
        this.msg = msg;
    }

    public ImportDeviceUserFailedInfo() {

    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getDeviceIndexCode() {
        return deviceIndexCode;
    }

    public void setDeviceIndexCode(String deviceIndexCode) {
        this.deviceIndexCode = deviceIndexCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
