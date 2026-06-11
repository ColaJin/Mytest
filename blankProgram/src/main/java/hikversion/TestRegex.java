package hikversion;

import cn.hutool.core.comparator.VersionComparator;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试正则
 * @Date:2025/1/3
 */
public class TestRegex {
    public static void main(String[] args) {
        String s = "select new com.hikvision.ebs.device.vo.ChannelVo(name,channelType," +
                "deviceTypeCode,channelNo,indexCode,gbIndexCode,onlineStatus,customIndexCode) from Channel " +
                "where parentIndexCode=:parentIndexCode and isDel='false' order by deviceTypeCode,channelNo";
        String countSql = "select count(*) from " + s.split(" (?i)from ")[1];
        System.out.println(countSql);
        countSql = countSql.split("(?i)order by")[0];
        System.out.println(countSql);


        VersionComparator comparator = new VersionComparator();
        List<ModelTest> models = new ArrayList<>();
        ModelTest modelTest1 = new ModelTest("1.0.0");
        ModelTest modelTest2 = new ModelTest("2.0.0");
        models.add(modelTest1);
        models.add(modelTest2);
        models.sort((o1, o2) -> comparator.compare(o2.getVersionNo(), o1.getVersionNo()));

        System.out.println(JSONObject.toJSONString(models));
    }
}
