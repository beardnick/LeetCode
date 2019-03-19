package normal;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class LeetCode279 {

    private static Vector<Integer> a;
    private static int[] solved;

    public static int solve(int n , int i){
        if(solved[n] != 0){
           return solved[n];
        }
        if(n == 0){
            return 0;
        }else if(i == 1){
            return n;
        }
        else {
              int tmp = Math.min(solve(n, i - 1),
                    solve(n % a.get(i), i - 1) + n / a.get(i));
              solved[n] = tmp;
              return tmp;
        }
    }

    public static int numSquares(int n) {
        a = new Vector<>();
        solved = new int[n + 10];
        a.add(0);
        int i;
        for ( i = 1; a.get(i - 1) <= n; i++) {
            a.add(i * i);
        }
        i --;
        return solve(n, i);
    }

    public static void main(String[] args) {
        System.out.println(
                LeetCode279.numSquares(12)
        );
        System.out.println(
                LeetCode279.numSquares(13)
        );
        System.out.println(
                LeetCode279.numSquares(16)
        );
        System.out.println(
                LeetCode279.numSquares(436)
        );
    }
}
