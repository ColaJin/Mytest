package hikversion;

import java.io.Serializable;
import java.util.List;

/**
 * Created by maxiaogang on 2017/8/11.
 */
public class RegDeviceContentTest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -266520230587922042L;

	private List<String> regDevice;

	private List<String> delDevice;

	private String code;

	public List<String> getRegDevice() {
		return regDevice;
	}

	public void setRegDevice(List<String> regDevice) {
		this.regDevice = regDevice;
	}

	public List<String> getDelDevice() {
		return delDevice;
	}

	public void setDelDevice(List<String> delDevice) {
		this.delDevice = delDevice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
