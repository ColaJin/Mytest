package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1108.IP地址无效化
 * @Date:2024/8/14
 */
public class DefangIPaddr {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
