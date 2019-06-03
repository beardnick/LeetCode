package practice;


import java.util.Scanner;

public class RobotJump {

//    public static int MAX_CAP = 100010;
    public static int[]  f;
    public static int[] vis;

    public static int cell(int a, int b) {
        return a %b == 0 ? a / b : a / b + 1;
    }

    public static int solution(int k, int[] h) {
        f = new int[h.length];
        vis = new int[h.length];
        return fun(k, h);
    }

    public static int fun(int k, int[] h) {
        if (k == h.length - 1) {
            return 0;
        }
        if (vis[k] == 1) {
            return f[k];
        }
        int cur = cell(h[k + 1] , 2);
        for (int i = k + 1; i < h.length ; i++) {
            cur = Math.max(cur, cell(fun(k + 1, h) + h[k + 1], 2));
        }
//        System.out.println("f" + k + ":" + cur);
        f[k] = cur;
        vis[k] = 1;
        return cur;
    }

    public static void main(String[] args) {
//        System.out.println(solution(0, new int[]{0,3,4,3,2,4}));
//        System.out.println(solution(0, new int[]{0,4,4,4}));
//        System.out.println(solution(0, new int[]{0,1,6,4}));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(0,arr));
    }
}
