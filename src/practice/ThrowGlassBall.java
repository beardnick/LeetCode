package practice;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class ThrowGlassBall {
//    腾讯大厦有39层，你手里有两颗一抹一眼的玻璃珠。当你拿着玻璃珠在某一层往下扔的时候，
//    一定会有两个结果，玻璃珠碎了或者没碎。大厦有个临界楼层。低于它的楼层，往下扔玻璃珠，
//    玻璃珠不会碎，等于或高于它的楼层，扔下玻璃珠，玻璃珠一定会碎。玻璃珠碎了就不能再扔。
//    现在让你设计一种方式，使得在该方式下，最坏的情况扔的次数比其他任何方式最坏的次数都少。
//    也就是设计一种最有效的方式。

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

    public static int[] solve(int x) {
        if (x < 1) {
            return new int[0];
        }
        int[] dp= new int[x + 1];
        dp[1] = 1;
        int[] steps = new int[x + 1];
        steps[1] = 1;
        for (int i = 2; i <= x; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 1; j < i ; j++) {
//                max(j, dp[i - j] + 1)
//                max对应了最坏情况
//                j 为第一个球在j楼扔
//                如果球破了，一共就需要j次
//                如果球没破就等于在i - j层的楼中扔两个玻璃球
//                temp = Math.min(temp, Math.max(j, dp[i - j] + 1));
                int res = Math.max(j, dp[i - j] + 1);
             if (res < temp) {
                   temp = res;
                   steps[i] = j;
//                    System.out.println("steps:" + Arrays.toString(steps));
                }
            }
            dp[i] = temp;
//            System.out.println("dp:" + Arrays.toString(dp));
        }
        int[] result = new int[dp[x] + 1];
        result[0] = dp[x];
        LinkedList<Integer> stack = new LinkedList<>();
        int cnt = 1;
//      j 当前逻辑上楼层的高度， i在j层楼中第一次在第几层楼扔球
        for (int i = steps[x], j = x; i >= 0  && i <= x && j >= 0 && j <= x && cnt < result.length; j = j - i, i = steps[j]) {
//            System.out.println("i:" + i + " j:" + j + Arrays.toString(result));
            result[cnt++] = i + x - j;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("steps:" + Arrays.toString(solve(1)));
        System.out.println("steps:" + Arrays.toString(solve(2)));
        System.out.println("steps:" + Arrays.toString(solve(4)));
        System.out.println("steps:" + Arrays.toString(solve(8)));
        System.out.println("steps:" + Arrays.toString(solve(10)));
        System.out.println("steps:" + Arrays.toString(solve(0)));
        System.out.println("steps:" + Arrays.toString(solve(-10)));
        System.out.println("steps:" + Arrays.toString(solve(100)));
        System.out.println("steps:" + Arrays.toString(solve(39)));
    }
}
