package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2011. 执行操作后的变量值
 * @Date:2023/12/22
 */
public class FinalValueAfterOperations {
    public int finalValueAfterOperations(String[] operations) {
        int rs = 0;
        for(int i = 0; i < operations.length;i++){
            if(operations[i].contains("+")){
                rs++;
            }else{
                rs--;
            }
        }
        return rs;
    }
}
