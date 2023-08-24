
package hikversion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelBlack {
    public static void main(String[] args) {
        String receiver = "4,5,6,10,23,24,24";
        String blacklist = "5,6,8,10";
        String[] receiverS = receiver.split(",");
        String[] beceiverS = blacklist.split(",");

        List<Integer> bList = new ArrayList<>();
        Set<Integer> rs = new HashSet<>();
        for (int i = 0; i < beceiverS.length; i++) {
            bList.add(Integer.valueOf(beceiverS[i]));
        }
        for (int i = 0; i < receiverS.length; i++) {
            if (!bList.contains(Integer.valueOf(receiverS[i]))){
                rs.add(Integer.valueOf(receiverS[i]));
            }
        }
        StringBuffer sb =new StringBuffer();
        if (rs.size() > 0){
            for(Integer set : rs){
                sb.append(set+" ");
            }
        }
        System.out.println(sb.toString());
    }
}
