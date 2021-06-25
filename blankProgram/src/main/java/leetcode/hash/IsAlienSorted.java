package leetcode.hash;

public class IsAlienSorted {
    public static void main(String[] args) {
        String[] words = new String[]{"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        // 字符串之间比较字典序
        // 按顺序两两比较单词，每个单词按照字符比较
        int[] alphbet = new int[26];

        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            alphbet[ch - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            // -1
            String str1 = words[i];
            String str2 = words[i + 1];

            // 同时比较字符串相同位置字符
            int index = 0;
            while (index < str1.length() && index < str2.length()) {
                if (alphbet[str1.charAt(index) - 'a'] > alphbet[str2.charAt(index) - 'a']) {
                    return false;
                } else if (alphbet[str1.charAt(index) - 'a'] == alphbet[str2.charAt(index) - 'a']) {
                    // 相同继续比较字符
                    index++;
                    // 可以比1长但是不能比1短
                    if ((index == str2.length() && index < str1.length())) {
                        return false;
                    }
                } else {
                    // 满足条件直接跳出循环
                    break;
                }

                // 存在问题空白字符时需要增加返回false的判断条件
            }

        }

        return true;
    }
}
