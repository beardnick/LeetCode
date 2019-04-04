package practice;

public class ThrowGlassBall {

//    public static int solve(int x) {
//        if (x <= 1) {
//            return 1;
//        }
//        int result = 1 << 30;
//        for (int i = 1; i < x; i++) {
////            if (i < result) {
////                result = i;
////            }
////            int tempSolve = solve(x - i ) + 1;
////            if ( tempSolve < result) {
////               result = tempSolve;
////            }
//            result = Math.min(result, Math.max(i, solve(x - i) + 1));
//        }
//        return result;
//    }

    public static int solve(int x) {
        if (x < 1) {
            return 0;
        }
        int[] dp= new int[x + 1];
        dp[1] = 1;
        for (int i = 2; i <= x; i++) {
            int temp = 1<<30;
            for (int j = 1; j < i ; j++) {
                temp = Math.min(temp, Math.max(j, dp[i - j] + 1));
            }
            dp[i] = temp;
        }
        return dp[x];
    }

    public static void main(String[] args) {
        System.out.println("steps:" + solve(1));
        System.out.println("steps:" + solve(2));
        System.out.println("steps:" + solve(4));
        System.out.println("steps:" + solve(8));
        System.out.println("steps:" + solve(10));
        System.out.println("steps:" + solve(39));
        System.out.println("steps:" + solve(0));
        System.out.println("steps:" + solve(-10));
        System.out.println("steps:" + solve(100));
    }
}
