package hikversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ClusterUtil {

    private static Logger log = LoggerFactory.getLogger(ClusterUtil.class);

    public static final String DEFAULT_CLUSTER_INDEXCIDE = "0";
    public static final String DAF_MAXNUM_URL = "/daf/v1/ability";
    public static final String DAF_MAXDRINUM_URL = "/daf/v1/drivers";
    public static final String DAF_STATUS_URL = "/daf/v1/status/dafStatus";
    public static final String DAF_THRESHOLD_URL = "/daf/v1/indicatorsThreshold";
    public static final String DAF_NOTIFY = "/daf/v1/notify";
    public static final String EVENT = "event";
    public static final String OPERATE = "operate";
    public static final String VERSION = "version";
    public static final String MAX = "max";
    public static final String REMAIN = "remain";
    public static final String NOW = "now";
    public static final String DASSTATEFLAG = "DasErrFlag_";
    public static final String ALLDEV = "all";
    public static final String DELDEV = "del";
    public static final String STATUS = "status";
    public static final String ENABLE = "enable";
    public static final String DISABLE = "disable";
    public static final String DEFAULTCLUSTERAUTOMOVE = "cluster.defaultClusterAutoMove";
    public static final int MAIN = 1;
    public static final int STANBY = 0;
    public static final String TREATY = "protocol.";
    public static final String TREATY_NAME = ".name";
    public static final int DAS_ERROR = 0;
    public static final int CLUSTERTYPE_TREATY = 2;
    public static final int CLUSTERTYPE_FREE = 1;
    public static final int CLUSTERTYPE_DAFAULT = 0;
    public static final int CLUSTERTYPE_ERROR = -1;
    public static final String DASPOSTFLAG = "DAS_POST_DRIVER";
    public static final String DASPOSTFAILEDFLAG = "DAS_POST_FAILED_DRIVER";
    public static final String DAC_OTAP_DEVSERIAL = "dac_otap_devserial_";
    public static final String DAC_OTAP_MSYERKEY = "dac_otap_masterkey_";
    

    /**
     * 进度条后缀
     */
    public static final String PROGRESS_BAR_SUFFIX = "_progress";
    public static final String PROGRESS_ALL_NUM = "_ALL_NUM";
    public static final String PROGRESS_ERR_NUM = "_ERR_NUM";
    public static final String PROGRESS_ERRORMSG = "_ERRORMSG";
    public static final String PROGRESS_LANGUAGE = "_LANGUAGE";

    public static final String STATES_NETMSG = "_NETMSG";
    public static final String LABEL = "label";
    public static final int LOCKEDTRYNUM = 3;
    public static final String ACTDEVTYPE = "_reg";
    public static final String ACTDEVTYPESQL = "%_reg%";
    public static final String EHOMETYPE = "ehome";
    public static final String EHOMESQL = "%ehome%";
    public static final String ADD = "add";
    public static final String MOD = "mod";
    public static final String DEL = "del";
    public static final String REGEX = ",";
    // 支持重定向
    public static final long SUPPORTREDIRECT = 1L;
    public static final long NOTSUPPORTREDIRECT = 0L;

    public static final long EXPTIME = 60 * 60 * 1000;
    public static final int LINE_ERROR = 1;
    public static final int DIR_DISABLED_NUM = -1;


}
