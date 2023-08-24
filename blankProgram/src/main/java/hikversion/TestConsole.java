package hikversion;

import com.alibaba.fastjson.JSON;
import org.activiti.engine.impl.util.json.JSONObject;

import java.util.Date;

/**
 * @author:jinyandong
 * @description:测试打印内容
 * @Date:2021/9/8
 */
public class TestConsole {
    // [deviceIndexCode=4895493e0bfc477fb55ec5e72dfdd07c,indexCode=null,multiRouteId=null] /das
    public static void main(String[] args) {
        System.out.println(new Date(new Date().getTime() - 15 * 24 * 60 * 60 * 1000));
        // JSONObject jsonobj = JSON.parseObject("{"drv_acs_hiksdk_net_lock_1.8.100":{"max":5000,"remain":5000,"protocols":["hiksdk_net"],"status":"enable"},"reg_isup5_register_svr_1.1.100":{"max":0,"remain":0,"protocols":["isup5_reg"],"status":"enable"},"drv_vss_onvif_general_1.11.100":{"max":2000,"remain":2000,"protocols":["onvif_net"],"status":"enable"},"drv_vss_acs_ehome_allinone_1.8.100":{"max":20000,"remain":20000,"protocols":["ehome_reg"],"status":"enable"},"drv_veh_bottom_hiksdk_1.1.100":{"max":500,"remain":500,"protocols":["hikcarcheck_net"],"status":"enable"},"drv_vss_encodedevice_gb35114_reg_1.1.100":{"max":5000,"remain":5000,"protocols":["gb35114_reg"],"status":"enable"},"drv_acs_hiksdk_net_general_1.8.100":{"max":20000,"remain":20000,"protocols":["hiksdk_net"],"status":"enable"},"drv_vss_hiksdk_general_1.12.100":{"max":20000,"remain":19996,"protocols":["hiksdk_net"],"status":"enable"},"drv_vss_ias_hiksdk_allinone_1.10.101":{"max":2000,"remain":2000,"protocols":["hiksdk_net"],"status":"enable"},"drv_acs_ezviz_lock_1.8.100":{"max":5000,"remain":5000,"protocols":["ezviz_net"],"status":"enable"},"drv_vss_isup5_1.5.100":{"max":10000,"remain":10000,"protocols":["isup5_reg"],"status":"enable"},"drv_acs_ezviz_1.8.100":{"max":20000,"remain":20000,"protocols":["ezviz_net"],"status":"enable"},"drv_vss_acs_isup_1.8.100":{"max":20000,"remain":20000,"protocols":["isup5_reg"],"status":"enable"},"drv_acs_compare_hiksdk_1.2.100":{"max":2000,"remain":2000,"protocols":["hiksdk_net"],"status":"enable"},"drv_emer_ehome_1.10.101":{"max":300,"remain":300,"protocols":["ehome_reg"],"status":"enable"},"drv_vss_dhsdk_general_1.10.102":{"max":500,"remain":499,"protocols":["dhsdk_net"],"status":"enable"},"drv_radar_isapi_net_1.2.100":{"max":2000,"remain":2000,"protocols":["isapi_net"],"status":"enable"},"drv_emer_hiksdk_allinone_1.10.101":{"max":10000,"remain":10000,"protocols":["hiksdk_net"],"status":"enable"},"reg_ehome_register_svr_1.11.100":{"max":0,"remain":0,"protocols":["ehome_reg"],"status":"enable"},"drv_vss_ehome_general_1.11.100":{"max":20000,"remain":20000,"protocols":["ehome_reg"],"status":"enable"},"drv_ias_isapi_net_1.1.102":{"max":2000,"remain":2000,"protocols":["isapi_net"],"status":"enable"},"drv_ias_mtasdk_1.10.102":{"max":2000,"remain":2000,"protocols":["mtasdk_reg"],"status":"enable"},"drv_ias_hiksdk_1.11.101":{"max":2000,"remain":1998,"protocols":["hiksdk_net"],"status":"enable"},"drv_type_hiksdk_general_1.2.100":{"max":0,"remain":0,"protocols":["hiksdk_net"],"status":"enable"},"drv_vss_gb_general_1.10.102":{"max":20000,"remain":20000,"protocols":["gb_reg"],"status":"enable"},"drv_vss_acs_allinone_1.8.100":{"max":20000,"remain":20000,"protocols":["hiksdk_net"],"status":"enable"},"drv_acs_ehome_general_1.8.100":{"max":20000,"remain":20000,"protocols":["ehome_reg"],"status":"enable"}}");
        // JSONObject jsonDri = jsonobj.getJSONObject(type);
        Integer CLUSTERTYPE = null;
        if (CLUSTERTYPE == ClusterUtil.CLUSTERTYPE_TREATY) {
            System.out.println(CLUSTERTYPE);
        }
    }
}
