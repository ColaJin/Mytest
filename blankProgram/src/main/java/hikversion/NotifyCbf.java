package hikversion;

import java.util.List;

/**
 * @Auther: tengleilei
 * @Date: 2021/7/21 11 42
 * @Description: 布控信息回调接口，通过这个接口进行布控信息采集上报
 */
public interface NotifyCbf {
    int NotifyCallBack(String pDataType, Object pBuf, int iBufLen, Object pUserData);

    int NotifyCallBack_Batch(List<DataModel> dataModels);
}
