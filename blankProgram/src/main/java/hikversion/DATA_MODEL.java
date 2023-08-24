package hikversion;

/**
 * @Auther: tengleilei
 * @Date: 2021/7/23 10 46
 * @Description:
 */
public class DATA_MODEL {
    public String			pJsonStructData;					//结构化数据  可以用于存储需要上报告警的json格式数据
    //char			szUrlStructData[BUF_LEN_1K];		//结构化数据URL, 用于存储
    //PICTURE_DATA	stRawPicData[PIC_NUM_MAX];			//图片数据
    //unsigned int	iRawPicCount;						//图片数量
    public String			szTraceId;//[BUF_LEN_512];				//标识ID
    public String           pJsonExtendData;                    //数据扩展字段  存储一些标识字段（如事件类型 、时间、）
    public String			pJsonOperatorData;					//运维信息

    public  Object pUserData;
}
