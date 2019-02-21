package normal;

import java.util.Vector;

public class LeetCode6 {
    public static String convert(String s, int numRows){
         StringBuilder[] a = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            a[i] = new StringBuilder();
        }
        int pointer = 0;
        boolean flag = true;
        while (flag){
            for (int i = 0; i < numRows ; i++, pointer ++) {
                if(pointer >= s.length()){
                    flag = false;
                    break;
                }
               a[i].append(s.charAt(pointer));
            }
            for (int i = numRows - 2; i >= 1 ; i --, pointer ++) {
                if(pointer >= s.length()){
                    flag = false;
                    break;
                }
                a[i].append(s.charAt(pointer));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder x:
             a) {
            sb.append(x.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(LeetCode6.convert("PAYPALISHIRING", 3));
        System.out.println(LeetCode6.convert("PAYPALISHIRING", 4));
    }
}
