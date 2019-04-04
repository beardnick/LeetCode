package algorithm;

public class LIS {

    public static int longestIncreaseSubstring(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[a.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestIncreaseSubstring(new int[]{1, 2, 3, 1, 2, 3, 4, 4, -1, 9, 2, 0}));
        System.out.println(longestIncreaseSubstring(new int[]{10,22,9,33,21,50,41,60,80}));
        System.out.println(longestIncreaseSubstring(new int[]{1}));
        System.out.println(longestIncreaseSubstring(new int[]{1, 1, 1, 1, 1}));
        System.out.println(longestIncreaseSubstring(new int[]{1, 1, -1, -1, -1}));
        System.out.println(longestIncreaseSubstring(new int[]{}));
    }
}
