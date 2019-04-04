package algorithm;

import java.util.Scanner;

public class DigitTriangle {

    public static int dp(int[][] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int len = a.length;
        int[][] dp = new int[len][len];
        for (int  k = 0;  k < len ; k++) {
            dp[len - 1][k] = a[len - 1][k];
        }
        for (int k = len - 2; k >= 0; k--) {
            for (int l = 0; l <= k ; l++) {
                dp[k][l] = Math.max(dp[k + 1][l], dp[k + 1][l + 1]) + a[k][l];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1},
                {1, 5},
                {1 , 9 , 10},
                {-1 , 11, 2, 1},
                {1, 19, 18, 20, 12}
        };
        System.out.println(dp(a));
        a = new int[][]{
                {1}
        };
        System.out.println(dp(a));
        a = new int[][]{
                {1},
                {2, 3}
        };
        System.out.println(dp(a));
        a = new int[][]{};
        System.out.println(dp(a));
        a = null;
        System.out.println(dp(a));
    }

}
