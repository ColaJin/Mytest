package leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        // 数组存储数据，然后根据数据进行返回的结果存储到set中，然后计算set的长度
        String[] secrets = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < words.length; i++) {
            //一个单词
            String temp = words[i];

            for(int j = 0; j < temp.length(); j ++) {
                // 当前值
                sb.append(secrets[temp.charAt(j)-'a']);
            }
            System.out.println(sb.toString());
            set.add(sb.toString());
            // 不能创建新的对象否则set存储数据相同
            sb.setLength(0);
        }

        return set.size();
    }
}
