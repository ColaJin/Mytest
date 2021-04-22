package jvm;

import java.util.Random;

public class AboutOOM {
    public static void main(String[] args) {
        String str = "jydxhshsuss";
        while (true){
            str += str+new Random().nextInt(88888888)+new Random().nextInt(999999999);
        }
    }
}
