package practice;

import java.util.Arrays;
import java.util.Scanner;

public class MaxPair {


    public static int solution(int[] arr){
        Arrays.sort(arr);
        int[] sum = new int[arr.length / 2];
        for (int i = 0; i < arr.length / 2 ; i++) {
            sum[i] = arr[i] + arr[arr.length - 1 - i];
        }
        Arrays.sort(sum);
        return Math.abs(sum[sum.length - 1 ] - sum[0]);
    }


    public static void main(String[] args) {
//        System.out.println(solution(new int[]{2, 6, 4, 3}));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr));
        }
    }

}
