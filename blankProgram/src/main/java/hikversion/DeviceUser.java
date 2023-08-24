package hikversion;

import javax.persistence.*;

/**
 * @author:jinyandong
 * @description:运维、维保用户和设备
 * @Date:2022/5/23
 */
@Entity
@Table(name = "device_user", schema = "public", catalog = "iotrm_iotrmdb")
public class DeviceUser {

    private Integer id;

    @ExcelHeader("设备编号")
    private String deviceIndexCode;

    @ExcelHeader("设备一级分类")
    private String deviceFir;

    @ExcelHeader("设备二级分类")
    private String deviceSec;

    @ExcelHeader("设备三级分类")
    private String deviceCategory;

    @ExcelHeader("设备四级分类")
    private String deviceSubCategory;

    @ExcelHeader("设备名称")
    private String deviceName;

    @ExcelHeader("所在场所")
    private String area;

    @ExcelHeader("所属部门")
    private String department;

    @ExcelHeader("厂商")
    private String manufacturer;

    @ExcelHeader("运维老师1姓名")
    private String user1;

    @ExcelHeader("运维老师1工号")
    private String userNo1;

    @ExcelHeader("运维老师2姓名")
    private String user2;

    @ExcelHeader("运维老师2工号")
    private String userNo2;

    @ExcelHeader("维保人1姓名")
    private String maintainer1;

    @ExcelHeader("维保人1工号")
    private String maintainerNo1;

    @ExcelHeader("维保人1电话")
    private String maintainerPho1;

    @ExcelHeader("维保人2姓名")
    private String maintainer2;

    @ExcelHeader("维保人2工号")
    private String maintainerNo2;

    @ExcelHeader("维保人2电话")
    private String maintainerPho2;

    @ExcelHeader("维保人3姓名")
    private String maintainer3;

    @ExcelHeader("维保人3工号")
    private String maintainerNo3;

    @ExcelHeader("维保人3电话")
    private String maintainerPho3;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "device_index_code")
    public String getDeviceIndexCode() {
        return deviceIndexCode;
    }

    public void setDeviceIndexCode(String deviceIndexCode) {
        this.deviceIndexCode = deviceIndexCode;
    }

    @Column(name = "user_1")
    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    @Column(name = "user_no_1")
    public String getUserNo1() {
        return userNo1;
    }

    public void setUserNo1(String userNo1) {
        this.userNo1 = userNo1;
    }

    @Column(name = "user_2")
    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    @Column(name = "user_no_2")
    public String getUserNo2() {
        return userNo2;
    }

    public void setUserNo2(String userNo2) {
        this.userNo2 = userNo2;
    }

    @Column(name = "maintainer_1")
    public String getMaintainer1() {
        return maintainer1;
    }

    public void setMaintainer1(String maintainer1) {
        this.maintainer1 = maintainer1;
    }

    @Column(name = "maintainer_no_1")
    public String getMaintainerNo1() {
        return maintainerNo1;
    }

    public void setMaintainerNo1(String maintainerNo1) {
        this.maintainerNo1 = maintainerNo1;
    }

    @Column(name = "maintainer_2")
    public String getMaintainer2() {
        return maintainer2;
    }

    public void setMaintainer2(String maintainer2) {
        this.maintainer2 = maintainer2;
    }

    @Column(name = "maintainer_no_2")
    public String getMaintainerNo2() {
        return maintainerNo2;
    }

    public void setMaintainerNo2(String maintainerNo2) {
        this.maintainerNo2 = maintainerNo2;
    }

    @Column(name = "maintainer_3")
    public String getMaintainer3() {
        return maintainer3;
    }

    public void setMaintainer3(String maintainer3) {
        this.maintainer3 = maintainer3;
    }

    @Column(name = "maintainer_no_3")
    public String getMaintainerNo3() {
        return maintainerNo3;
    }

    public void setMaintainerNo3(String maintainerNo3) {
        this.maintainerNo3 = maintainerNo3;
    }

    @Column(name = "device_fir")
    public String getDeviceFir() {
        return deviceFir;
    }

    public void setDeviceFir(String deviceFir) {
        this.deviceFir = deviceFir;
    }

    @Column(name = "device_sec")
    public String getDeviceSec() {
        return deviceSec;
    }

    public void setDeviceSec(String deviceSec) {
        this.deviceSec = deviceSec;
    }

    @Column(name = "device_category")
    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    @Column(name = "device_sub_category")
    public String getDeviceSubCategory() {
        return deviceSubCategory;
    }

    public void setDeviceSubCategory(String deviceSubCategory) {
        this.deviceSubCategory = deviceSubCategory;
    }

    @Column(name = "device_name")
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Column(name = "d_area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "d_department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name = "maintainer_pho_1")
    public String getMaintainerPho1() {
        return maintainerPho1;
    }

    public void setMaintainerPho1(String maintainerPho1) {
        this.maintainerPho1 = maintainerPho1;
    }

    @Column(name = "maintainer_pho_2")
    public String getMaintainerPho2() {
        return maintainerPho2;
    }

    public void setMaintainerPho2(String maintainerPho2) {
        this.maintainerPho2 = maintainerPho2;
    }

    @Column(name = "maintainer_pho_3")
    public String getMaintainerPho3() {
        return maintainerPho3;
    }

    public void setMaintainerPho3(String maintainerPho3) {
        this.maintainerPho3 = maintainerPho3;
    }
}
