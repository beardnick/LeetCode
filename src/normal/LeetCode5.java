package normal;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

public class LeetCode5 {

    public static String longestPalindromeOld(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int maxLen = Integer.MIN_VALUE;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
//            int left = 0;
//            int right = 0;
            for (int j = 0; j <= i; j++) {
                int left = i - j;
                int right = i + j;
                if (left >= 0 && right < s.length() && chars[left] == chars[right] ) {
//                    System.out.println("sub:" + s.substring(left, right + 1));
                    if (right - left + 1 > maxLen) {
                        begin = left;
                        end = right;
                        maxLen = right - left + 1;
                    }
                } else {
                    break;
                }
            }

            for (int j = 0; j <= i + 1; j++) {
                int left = i - j + 1;
                int right = i + j;
                if (left >= 0  && left < s.length() && right >= 0 && right < s.length() && chars[left] == chars[right] ) {
//                    System.out.println("sub:" + s.substring(left, right + 1));
                    if (right - left + 1 > maxLen) {
                        begin = left;
                        end = right;
                        maxLen = right - left + 1;
                    }
                } else {
                    break;
                }
            }
        }
        return s.substring(begin, end + 1);
    }


    public  String longestPalindromeNew(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLen = 0;
        int begin = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        boolean[][] sym = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen ; j < s.length(); j++) {
                if (isSym(i, j, chars, sym)) {
//                    System.out.println("sub:" + s.substring(i , j + 1));
                    maxLen = j - i + 1;
                    begin = i;
                    end = j;
                }
            }
        }
        return s.substring(begin, end + 1);
    }

    public static boolean isSym(int left, int right, char[] chars, boolean[][] sym) {
//        System.out.println("sym:");
//        System.out.println(Arrays.deepToString(sym));
        if (chars == null || left < 0 || left > chars.length || right < 0 || right > chars.length || left > right) {
            return false;
        }
        if (left == right || (left == right - 1 && chars[left] == chars[right])) {
            return sym[left][right] = true;
        }
        if (chars[left] == chars[right]) {
            return sym[left][right] = isSym(left + 1, right - 1, chars, sym);
        } else {
            return sym[left][right] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeOld("babad"));
        System.out.println(longestPalindromeOld(""));
        System.out.println(longestPalindromeOld("aaaaa"));
        System.out.println(longestPalindromeOld("caba"));
//        System.out.println(new LeetCode5().longestPalindrome("cbbd"));
        System.out.println(longestPalindromeOld("bb"));
        System.out.println(longestPalindromeOld("ccc"));
    }
}
