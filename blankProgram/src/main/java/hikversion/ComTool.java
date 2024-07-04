package hikversion;


import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: tengleilei
 * @Date: 2021/7/19 15 35
 * @Description:
 */
public class ComTool {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        String timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeNow;
    }

    /**
     * 转化时间格式
     *
     * @param pattern
     * @param time
     * @return
     */
    public static String getFormatTime(String pattern, Long time) {
        Date date = new Date(time);
        String destTime = new SimpleDateFormat(pattern).format(date);
        return destTime;
    }


    /**
     * 根据格式 获取当前时间
     *
     * @param format
     * @return
     */
    public static String getCurrentTime(String format) {
        String timeNow = new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
        return timeNow;
    }

    /**
     * 判断字符串是否为空
     *
     * @param info
     * @return
     */
    public static boolean isBlankStr(String info) {
        if (info == null || info.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取guid
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

    /**
     * 获取guid
     *
     * @return
     */
    public static String getGuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 等待 指定时间  毫秒
     *
     * @param ms
     */
    public static void waitMillSecTime(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 转化错误码
     *
     * @param nErrcode
     * @return
     */
    public static String converErrorIntToString(int nErrcode) {
        String strError;
        if (nErrcode != 0) {
            strError = "0x0" + Integer.toHexString(nErrcode);
        } else {
            strError = Integer.toHexString(nErrcode);
        }

        return strError;
    }

    /**
     * 转化错误码 1 == 》 0x00000001
     *
     * @param nErrCode
     * @return
     */
    public static String converErrorCode(int nErrCode) {
        if (nErrCode == -1){
            return "-1";
        }
        String strErr = String.format("[0x%08x]", nErrCode);
        return strErr;
    }

    /**
     * 检查文件是否存在
     *
     * @param filePath
     * @return
     */
    public static boolean checkFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }


    /**
     * 取北京时间
     *
     * @return
     */
    public static String getBeijingTime() {
        return getFormatedDateString(8);
    }

    /**
     * 此函数非原创，从网上搜索而来，timeZoneOffset原为int类型，为班加罗尔调整成float类型
     * timeZoneOffset表示时区，如中国一般使用东八区，因此timeZoneOffset就是8
     *
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(float timeZoneOffset) {
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }

        int newTime = (int) (timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }

    /**
     * 计算中文长度
     * @param str
     * @return
     */
    public static int getStrLeng(String str){
        int strLen = 0;
        String chinese = "[\u0391-\uFFE5]";
        for (int i=0; i<str.length() ; i++){
            String tmp = str.substring(i,i+1);
            if (tmp.matches(chinese)){
                strLen += 3;
            }else {
                strLen += 1;
            }

        }
        return strLen;
    }

    /**
     * 获取当前程序的pid
     * @return
     */
    public static int getProcessPid(){
        int pid = 0;
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        System.out.println("当前进程的标识为："+name);
        int index = name.indexOf("@");
        if (index != -1) {
            pid = Integer.parseInt(name.substring(0, index));
            System.out.println("当前进程的PID为："+pid);
        }
        return pid;
    }

}
