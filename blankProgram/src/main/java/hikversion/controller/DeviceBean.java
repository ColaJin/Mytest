/**
 * @ProjectName: CMS基线平台软件
 * @Copyright: 2010 HangZhou Hikvision System Technology Co., Ltd. All Right Reserved.
 * @address: http://www.hikvision.com
 * @date: 2017年3月15日 上午9:49:51
 * @Description: 本内容仅限于杭州海康威视数字技术系统公司内部使用，禁止转发.
 */
package hikversion.controller;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * </p>
 * 
 * @author guodong 2017年3月15日 上午9:49:51
 * @version V1.0
 */
public class DeviceBean  {
	private String indexCode;
	// /:*?\"<|'>   
	//@Pattern(regexp="^[^\"']*$", message="name not contain \"'")
	private String name;
	
	public static void main(String[] args) {
		String reg = "^[^/:*?\"<>'|\\\\]*$";
		// ^[^#&*\/|:<>?\"]*$
		// ^[^/:*?\"<>'|\\\\]*$
		String str = "\\&";
		System.out.println(str.matches(reg));
		str = "/";
		System.out.println(str.matches(reg));
		str = "<";
		System.out.println(str.matches(reg));
		str = "fghf>";
		System.out.println(str.matches(reg));
		str = "\"";
		System.out.println(str.matches(reg));
		str = "'";
		System.out.println(str.matches(reg));
		str = "fghfg.?>?!@#h";
		System.out.println(str.matches(reg));
		str = "fghf|";
		System.out.println(str.matches(reg));
		str = "hfgh;',.>?";
		System.out.println(str.matches(reg));
		str = "fghfg:;'";
		System.out.println(str.matches(reg));
		str = "765765ghjghj-+，。、；‘、《》？：*“,.";
		System.out.println(str.matches(reg));
		str = "";
		System.out.println(str.matches(reg));
	}
	
	@JSONField(serialize=false)
	private String orgIndexCode;

	private String parentIndexCode;

	// @NotBlank(message = "topParentIndexCode cannot be blank.")
	private String topParentIndexCode;

	private String deviceTypeCode;

	private String deviceCategory;

	private String treatyType;

	private String deviceType;
	
	private String deviceTypeVersion;

	private String manufacturer;

	private String deviceIndexCode;

	private String deviceKey;

	private String deviceKeyVersion;
	
	private String userName;
	private String password;
	
	/**
	 * 萤石设备接入
	 */
	private String userId;
	private String 	appKey;
	
	private String secret;

	private String encrypyType;

	private Integer pwdStrength;

	private Integer netZoneId = 0;

	private String belongIndexCode;

	private String clusterIndexCode;

	// private String belongServiceAddr;
	private Integer addrType;

	private String addr;

	private Integer port;
	private Integer serialPort;
	private Integer serialBaud;
	private Integer serialValidBit;
	private Integer serialDataBit;
	private Integer serialStopBit;

	private String serialAddrCode;
	private Long extend1;
	private Long extend2;
	private String extend3;
	private String extend4;

	private Long deviceId;

	private Long parentDeviceId;

	private Double latitudeDegree;
	private Float latitudeMinute;
	private Float latitudeSecond;
	private Double longitudeDegree;
	private Float longitudeMinute;
	private Float longitudeSecond;


	private Float altitude;

	private String zoneId;

	private String parseProto;
	private String clusterId;
	
	private Integer level;
	private List<ChannelBean> channelsInfo = new ArrayList<ChannelBean>();
	
	private Map<String, Integer> channelsCount = new HashMap<>();

    
	private long status;

	@JSONField(serialize = false)
	private String remoteGetChannels;
	
	//0是已注册  1是未注册
	private Long registerStatus;
	
	private String registerCode;
	
	private Long onlineStatus=-1L;
	
	private String deviceModel;
	private String publicKey;
	private String deviceSerialNum;
	
	//add by weilai5 公安需求
    private Integer devProductType;
    private Integer devClass;
	
    private String matchingMethod;     //驱动匹配方式
    
    //add for ehome5
    private String deviceSecretKey;
    private Long supportRedirect;
    
	public Integer getDevProductType() {
		return devProductType;
	}

	public Integer getDevClass() {
		return devClass;
	}

	public void setDevProductType(Integer devProductType) {
		this.devProductType = devProductType;
	}

	public void setDevClass(Integer devClass) {
		this.devClass = devClass;
	}

	public String getDeviceSerialNum() {
		return deviceSerialNum;
	}

	public void setDeviceSerialNum(String deviceSerialNum) {
		this.deviceSerialNum = deviceSerialNum;
	}

	public Double getLongitudeDegree() {
		return longitudeDegree;
	}

	public void setLongitudeDegree(Double longitudeDegree) {
		this.longitudeDegree = longitudeDegree;
	}

	public Float getLongitudeMinute() {
		return longitudeMinute;
	}

	public void setLongitudeMinute(Float longitudeMinute) {
		this.longitudeMinute = longitudeMinute;
	}

	public Float getLongitudeSecond() {
		return longitudeSecond;
	}

	public void setLongitudeSecond(Float longitudeSecond) {
		this.longitudeSecond = longitudeSecond;
	}
	
	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

	public Long getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(Long registerStatus) {
		this.registerStatus = registerStatus;
	}

	public String getDeviceCategory() {
		return deviceCategory;
	}

	public void setDeviceCategory(String deviceCategory) {
		this.deviceCategory = deviceCategory;
	}


	/**
	 * 扩展属性json
	 */
	private Map<String, Object> extendJson = new HashMap<>();

	public String getRemoteGetChannels() {
		return remoteGetChannels;
	}

	public void setRemoteGetChannels(String remoteGetChannels) {
		this.remoteGetChannels = remoteGetChannels;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getParseProto() {
		return parseProto;
	}

	public void setParseProto(String parseProto) {
		this.parseProto = parseProto;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public Long getExtend1() {
		return extend1;
	}

	public void setExtend1(Long extend1) {
		this.extend1 = extend1;
	}

	public Long getExtend2() {
		return extend2;
	}

	public void setExtend2(Long extend2) {
		this.extend2 = extend2;
	}

	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	public String getExtend4() {
		return extend4;
	}

	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgIndexCode() {
		return orgIndexCode;
	}

	public void setOrgIndexCode(String orgIndexCode) {
		this.orgIndexCode = orgIndexCode;
	}

	public String getParentIndexCode() {
		return parentIndexCode;
	}

	public void setParentIndexCode(String parentIndexCode) {
		this.parentIndexCode = parentIndexCode;
	}

	public String getTopParentIndexCode() {
		return topParentIndexCode;
	}

	public void setTopParentIndexCode(String topParentIndexCode) {
		this.topParentIndexCode = topParentIndexCode;
	}

	public String getDeviceTypeCode() {
		return deviceTypeCode;
	}

	public void setDeviceTypeCode(String deviceTypeCode) {
		this.deviceTypeCode = deviceTypeCode;
	}

	public String getTreatyType() {
		return treatyType;
	}

	public void setTreatyType(String treatyType) {
		this.treatyType = treatyType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDeviceIndexCode() {
		return deviceIndexCode;
	}

	public void setDeviceIndexCode(String deviceIndexCode) {
		if (StringUtils.isNotBlank(deviceIndexCode)) {
			this.deviceIndexCode = deviceIndexCode;
		}
	}

	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}

	public String getDeviceKeyVersion() {
		return deviceKeyVersion;
	}

	public void setDeviceKeyVersion(String deviceKeyVersion) {
		this.deviceKeyVersion = deviceKeyVersion;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncrypyType() {
		return encrypyType;
	}

	public void setEncrypyType(String encrypyType) {
		this.encrypyType = encrypyType;
	}

	public Integer getPwdStrength() {
		return pwdStrength;
	}

	public void setPwdStrength(Integer pwdStrength) {
		this.pwdStrength = pwdStrength;
	}

	public Integer getNetZoneId() {
		return netZoneId;
	}

	public void setNetZoneId(Integer netZoneId) {
		this.netZoneId = netZoneId;
	}

	public String getBelongIndexCode() {
		return belongIndexCode;
	}

	public void setBelongIndexCode(String belongIndexCode) {
		this.belongIndexCode = belongIndexCode;
	}

	// public String getBelongServiceAddr() {
	// return belongServiceAddr;
	// }
	//
	// public void setBelongServiceAddr(String belongServiceAddr) {
	// this.belongServiceAddr = belongServiceAddr;
	// }

	public Integer getAddrType() {
		return addrType;
	}

	public void setAddrType(Integer addrType) {
		this.addrType = addrType;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getSerialPort() {
		return serialPort;
	}

	public void setSerialPort(Integer serialPort) {
		this.serialPort = serialPort;
	}

	public Integer getSerialBaud() {
		return serialBaud;
	}

	public void setSerialBaud(Integer serialBaud) {
		this.serialBaud = serialBaud;
	}

	public Integer getSerialValidBit() {
		return serialValidBit;
	}

	public void setSerialValidBit(Integer serialValidBit) {
		this.serialValidBit = serialValidBit;
	}

	public Integer getSerialDataBit() {
		return serialDataBit;
	}

	public void setSerialDataBit(Integer serialDataBit) {
		this.serialDataBit = serialDataBit;
	}

	public Integer getSerialStopBit() {
		return serialStopBit;
	}

	public void setSerialStopBit(Integer serialStopBit) {
		this.serialStopBit = serialStopBit;
	}

	public String getSerialAddrCode() {
		return serialAddrCode;
	}

	public void setSerialAddrCode(String serialAddrCode) {
		this.serialAddrCode = serialAddrCode;
	}

	public Map<String, Object> getExtendJson() {
		return extendJson;
	}

	public void setExtendJson(Map<String, Object> extendJson) {
		this.extendJson = extendJson;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Long getParentDeviceId() {
		return parentDeviceId;
	}

	public void setParentDeviceId(Long parentDeviceId) {
		this.parentDeviceId = parentDeviceId;
	}

	public Double getLatitudeDegree() {
		return latitudeDegree;
	}

	public void setLatitudeDegree(Double latitudeDegree) {
		this.latitudeDegree = latitudeDegree;
	}


	public Float getAltitude() {
		return altitude;
	}

	public void setAltitude(Float altitude) {
		this.altitude = altitude;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public List<ChannelBean> getChannelsInfo() {
		return channelsInfo;
	}

	public void setChannelsInfo(List<ChannelBean> channelsInfo) {
		this.channelsInfo = channelsInfo;
	}

	public Map<String, Integer> getChannelsCount() {
		return channelsCount;
	}

	public void setChannelsCount(Map<String, Integer> channelsCount) {
		this.channelsCount = channelsCount;
	}

	public Float getLatitudeMinute() {
		return latitudeMinute;
	}

	public void setLatitudeMinute(Float latitudeMinute) {
		this.latitudeMinute = latitudeMinute;
	}

	public Float getLatitudeSecond() {
		return latitudeSecond;
	}

	public void setLatitudeSecond(Float latitudeSecond) {
		this.latitudeSecond = latitudeSecond;
	}


	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Long getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(Long onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceTypeVersion() {
		return deviceTypeVersion;
	}

	public void setDeviceTypeVersion(String deviceTypeVersion) {
		this.deviceTypeVersion = deviceTypeVersion;
	}
	public String getUserId() {
		return userId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getSecret() {
		return secret;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getMatchingMethod() {
		return matchingMethod;
	}

	public void setMatchingMethod(String matchingMethod) {
		this.matchingMethod = matchingMethod;
	}

	public String getDeviceSecretKey() {
		return deviceSecretKey;
	}

	public void setDeviceSecretKey(String deviceSecretKey) {
		this.deviceSecretKey = deviceSecretKey;
	}
	
	public Long getSupportRedirect() {
		return supportRedirect;
	}

	public void setSupportRedirect(Long supportRedirect) {
		this.supportRedirect = supportRedirect;
	}


	@Override
	public String toString() {
		return "DeviceBean [indexCode=" + indexCode + ", name=" + name
				+ ", orgIndexCode=" + orgIndexCode + ", parentIndexCode="
				+ parentIndexCode + ", topParentIndexCode="
				+ topParentIndexCode + ", deviceTypeCode=" + deviceTypeCode
				+ ", deviceCategory=" + deviceCategory + ", treatyType="
				+ treatyType + ", deviceType=" + deviceType + ", manufacturer="
				+ manufacturer + ", deviceIndexCode=" + deviceIndexCode
				+ ", deviceKey=" + deviceKey + ", deviceKeyVersion="
				+ deviceKeyVersion + ", netZoneId=" + netZoneId
				+ ", belongIndexCode=" + belongIndexCode + ", addrType="
				+ addrType + ", addr=" + addr + ", port=" + port
				+ ", deviceId=" + deviceId + ", parentDeviceId="
				+ parentDeviceId + ", parseProto=" + parseProto
				+ ", clusterId=" + clusterId + ", level=" + level + ", status="
				+ status + ", registerStatus=" + registerStatus
				+ ", registerCode=" + registerCode + ", onlineStatus="
				+ onlineStatus + ", deviceSerialNum=" + deviceSerialNum + ", userId="+userId+",matchingMethod="+matchingMethod+" ]";
	}

	public String getClusterIndexCode() {
		return clusterIndexCode;
	}

	public void setClusterIndexCode(String clusterIndexCode) {
		this.clusterIndexCode = clusterIndexCode;
	}
}
