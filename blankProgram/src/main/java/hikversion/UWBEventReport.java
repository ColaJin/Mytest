package hikversion;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author tengleilei
 * @date 2022/3/8 11:43
 * @description: TODO
 */
@Data
public class UWBEventReport {
    //设备ID
    private String deviceId;
    //消息类型=eventReport
    //private String messageType;
    //终端设备识别号
    private String imei;
    //终端sim卡标识
    //private String imsi;
    //设备编号
    //private String deviceSn;
    //时间戳
    private Long timestamp;
    //事件类型  1：温度告警   2：烟雾告警  3：电池低压告警  4：设备故障告警
    private Integer eventType;
    //事件上报数据
    private JSONObject eventContent;

}
