/**
 * @ProjectName: CMS基线平台软件
 * @Copyright: 2010 HangZhou Hikvision System Technology Co., Ltd. All Right Reserved.
 * @address: http://www.hikvision.com
 * @date: 2017年3月15日 上午11:10:16
 * @Description: 本内容仅限于杭州海康威视数字技术系统公司内部使用，禁止转发.
 */
package hikversion.controller;

import java.util.List;


/**
 * <p></p>
 * @author chenyibin 2017年3月15日 上午11:10:16
 * @version V1.0   
 */
public class DevicePostContent {
	private String resourceModel = "dac";
	private String resourceModelVersion = "1.0.0";
	private List<DeviceBean> devices;
	private List<ChannelBean> channels;

	public DevicePostContent() {
	}

	public DevicePostContent(List<DeviceBean> devices) {
		this.devices = devices;
	}
    public List<DeviceBean> getDevices() {
    	return devices;
    }

    public void setDevices(List<DeviceBean> devices) {
    	this.devices = devices;
    }

    public List<ChannelBean> getChannels() {
    	return channels;
    }

    public void setChannels(List<ChannelBean> channels) {
    	this.channels = channels;
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
