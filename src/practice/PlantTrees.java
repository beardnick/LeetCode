package practice;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

public class PlantTrees {


    private static  int types;
    private static  int[] nums;
    private static int[] list;
    private static boolean solved;

    // TODO: 19-5-8 如果最多的树的数量大于总数量的1/2就剪枝

    public static int[] solution(int n, int[] a) {
       types = n;
       nums = a;
       solved = false;
        list = new int[2010];
        list[0] = 0;
        if (solve(1)) {
            return list;
        } else {
            return new int[0];
        }
    }

    public static boolean solve(int index){
        int start = 1;
        boolean allZero = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
               start = i + 1;
               allZero = false;
               break;
            }
        }
        if (allZero) {
            return true;
        }
        for (int i = start; i <= types ; i++) {
            if (i != list[index - 1] && nums[i -1] != 0) {
                list[index] =  i;
                nums[i - 1] -= 1;
                if (solve(index + 1)) {
                    return true;
                }
                nums[i - 1] += 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(3, new int[]{4, 2, 1})));
//        System.out.println(Arrays.toString(solution(3, new int[]{1, 1, 5})));
//        System.out.println(Arrays.toString(solution(1, new int[]{10})));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] res = solution(n, a);
            if (res.length > 0) {
                int cnt = 1;
                while (res[cnt] != 0) {
                    System.out.printf("%d ", res[cnt]);
                    cnt ++;
                }
                System.out.println();
            }else{
                System.out.println("-");
            }
        }
    }
}
