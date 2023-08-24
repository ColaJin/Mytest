/**
 * @ProjectName: CMS基线平台软件
 * @Copyright: 2010 HangZhou Hikvision System Technology Co., Ltd. All Right Reserved.
 * @address: http://www.hikvision.com
 * @date: 2017年3月7日 下午5:29:26
 * @Description: 本内容仅限于杭州海康威视数字技术系统公司内部使用，禁止转发.
 */
package hikversion.controller;

import java.util.List;
import java.util.Map;


/**
 * <p>DeviceController 提交设备资源的数据模型</p>
 * @author chenyibin 2017年3月7日 下午5:29:26
 * @version V1.0   
 */
public class DeviceSubmitContent {
	private String resourceModel = "dac";
	private String resourceModelVersion = "1.0.0";
	private List<Map<String, Object>> devices;
	private List<Map<String, Object>> channels;

	
    public List<Map<String, Object>> getChannels() {
		return channels;
	}

	public void setChannels(List<Map<String, Object>> channels) {
		this.channels = channels;
	}

	public List<Map<String, Object>> getDevices() {
    	return devices;
    }
	
    public void setDevices(List<Map<String, Object>> devices) {
    	this.devices = devices;
    }

	public String getResourceModel() {
		return resourceModel;
	}

	public void setResourceModel(String resourceModel) {
		this.resourceModel = resourceModel;
	}

	public String getResourceModelVersion() {
		return resourceModelVersion;
	}

	public void setResourceModelVersion(String resourceModelVersion) {
		this.resourceModelVersion = resourceModelVersion;
	}
	
	
	
}
