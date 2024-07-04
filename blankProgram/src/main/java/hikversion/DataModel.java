package hikversion;

import com.alibaba.fastjson.JSONObject;

/**
 * @author tengleilei
 * @date 2023/4/7 10:15
 * @description: TODO
 */
public class DataModel {
    //事件类型
    private int eventType = -1;
    //状态 1-开始、2-结束、0-瞬时、3-脉冲
    private int status = -1;
    //超时时间
    private int timeout = -1;
    //设备id 或是通道id
    private String srcIndex;
    //设备名称 或是通道名称
    private String srcName;
    //父设备id
    private String srcParentIndex;
    //设备类型
    private String srcType;
    //上报时间
    private String happenTime;
    //是否otap事件 false：dac  true：otap
    private boolean bOtap = false;
    //具体事件格式
    /**
     * otap事件：含有basic和payload
     * dac事件：实际具体事件格式
     */
    private JSONObject data;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getSrcIndex() {
        return srcIndex;
    }

    public void setSrcIndex(String srcIndex) {
        this.srcIndex = srcIndex;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public String getSrcParentIndex() {
        return srcParentIndex;
    }

    public void setSrcParentIndex(String srcParentIndex) {
        this.srcParentIndex = srcParentIndex;
    }

    public String getSrcType() {
        return srcType;
    }

    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

    public String getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(String happenTime) {
        this.happenTime = happenTime;
    }

    public boolean isbOtap() {
        return bOtap;
    }

    public void setbOtap(boolean bOtap) {
        this.bOtap = bOtap;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
