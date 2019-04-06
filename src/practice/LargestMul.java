package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LargestMul {

    public static Long solve(Long[] a) {
        if (a == null || a.length < 3) {
            return 0L;
        }
        Long x = a[0], y = a[1], z = a[2];
        Long tmp[] = new Long[4];
        for (int i = 3; i < a.length ; i++) {
            tmp[0] = x * y * z;
            tmp[1] = a[i] * y * z;
            tmp[2] = x * a[i] * z;
            tmp[3] = x * y * a[i];
            Long tmpMax = Long.MIN_VALUE;
            for (int j = 0; j < tmp.length; j++) {
                /**
                 * 算法错误的地方就在这里
                 * 每次最大乘积的三个数有好几组
                 * 这里只保留了一组
                 * 这几组在这里一样大，可能在另外的地方是另外几组交换的时候最大
                 */
                if (tmp[j] > tmpMax) {
                    tmpMax = tmp[j];
                }
            }
//            System.out.println("tmpMax:" + tmpMax);
            if (tmpMax == tmp[1]) {
                x = a[i];
            }
            if (tmpMax == tmp[2]) {
                y = a[i];
            }
            if (tmpMax == tmp[3]) {
                z = a[i];
            }
        }
        System.out.println("x:" + x +" y:" + y + " z:" + z);
        return x * y * z;
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(solve(new Long[]{3L, 4L, 1L, 2L}));
//        System.out.println(solve(new Long[]{0, 4, 1, 2}));
//        System.out.println(solve(new Long[]{-3, -4, 1, 2}));
//        System.out.println(solve(new Long[]{1, 1, 1, 1}));
//        System.out.println(solve(new Long[]{-1, -4, -1, -2}));
//        System.out.println(solve(new Long[]{-1}));
//        System.out.println(solve(null));
//        System.out.println(solve(new Long[]{}));

//        Scanner sc = new Scanner(System.in);
//        ArrayList<Long> list = new ArrayList<>();
//        while (sc.hasNextLine()) {
//            String[] line = sc.nextLine().split(" ");
////            System.out.println(Arrays.toString(line));
//            Long[] a = new Long[line.length];
//            for (int i = 0; i < line.length; i++) {
//                a[i] = Long.valueOf(line[i]);
//            }
//            System.out.println(solve(a));
//        }

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLong()) {
//        String n = sc.nextLine();
//        String[] line = sc.nextLine().split(" ");
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(ir);
        bf.readLine();
        String[] line = bf.readLine().split(" ");
        Long[] a = new Long[line.length];
            for (int i = 0; i < line.length; i++) {
                a[i] = Long.valueOf(line[i]);
            }
            System.out.println(solve(a));
//        }
    }
}
