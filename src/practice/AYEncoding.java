package practice;

import java.util.Arrays;
import java.util.Scanner;

public class AYEncoding {

    public static int getIndex(String code, int len) {
        if (code == null ||  code.length() < 1) {
            return 0;
        }
        int pre = 1;
        /**
         * 求比当前串更小的串的个数
         * 排列组合，如baca，第一个字符可以是a,b
         *1.
         *  确定第一个为a,则剩下的三位串的所有组合都小于baca
         * 所有组合数为1 + 25 * ( 1 + 25 * (1 + 25) ) )
         * 1 (空只有一种情况)  25(a~y,25种情况成乘以二位串的所有数量)
         * 2.
         * 确定第一个字符为b,则递归求比三位子串小的串的个数
         */
        for (int i = 0; i < len  - 1; i++) {
            pre = pre * 25 + 1;
        }
//        System.out.println("pre:" + pre);
        return  (code.toCharArray()[0] - 'a') * pre  + getIndex(code.substring(1, code.length()), len - 1);
    }

    public static void main(String[] args) {
//        System.out.println(getIndex("a", 4));
//        System.out.println(getIndex("baca", 4));
//        System.out.println(getIndex("aaa", 4));
//        System.out.println(getIndex("", 4));
//        System.out.println(getIndex(null, 4));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String code = sc.nextLine();
            System.out.println(getIndex(code, 4));
        }
    }
}
