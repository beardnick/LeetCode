package practice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MagicCub {


//    推导的速度太慢了
//    这种问题应该手动推导一下然后填上去
    public static int[] operation(int[] array, int direction) {
        int[] a = Arrays.copyOf(array, array.length);
        int x, y , z;
        switch (direction) {
            case 1:
                 x = a[0];
                 y = a[2];
                a[0] = a[6];
                a[2] = a[12];
                a[6] = a[16];
                a[12] = a[18];
                a[16] = a[20];
                a[18] = a[22];
                a[20] = x;
                a[22] = y;
                z = a[4];
                a[4] = a[5];
                a[5] = a[11];
                a[11] = a[10];
                a[10] = z;
                break;
            case 2:
                x = a[1];
                y = a[3];
                a[1] = a[7];
                a[3] = a[13];
                a[7] = a[17];
                a[13] = a[19];
                a[17] = a[21];
                a[19] = a[23];
                a[21] = x;
                a[23] = y;
                z = a[8];
                a[8] = a[14];
                a[14] = a[15];
                a[15] = a[9];
                a[9] = z;
                break;
            case 3:
                x = a[20];
                y = a[22];
                a[20] = a[16];
                a[22] = a[18];
                a[16] = a[6];
                a[18] = a[12];
                a[6] = a[0];
                a[12] = a[2];
                a[0] = x;
                a[2] = y;
                z = a[4];
                a[4] = a[10];
                a[10] = a[11];
                a[11] = a[5];
                a[5] = z;
                break;
            case 4:
                x = a[21];
                y = a[23];
                a[21] = a[17];
                a[23] = a[19];
                a[17] = a[7];
                a[19] = a[13];
                a[7] = a[1];
                a[13] = a[3];
                a[1] = x;
                a[3] = y;
                z = a[8];
                a[8] = a[9];
                a[9] = a[15];
                a[15] = a[14];
                a[14] = z;
                break;
            case 5:
                x = a[4];
                y = a[5];
                a[4] = a[6];
                a[5] = a[7];
                a[6] = a[8];
                a[7] = a[9];
                a[8] = a[23];
                a[9] = a[22];
                a[22] =y ;
                a[23] = x;
                z = a[0];
                a[0] = a[2];
                a[2] = a[3];
                a[3] = a[1];
                a[1] = z;
                break;
            case 6:
                x = a[10];
                y = a[11];
                a[10] = a[12];
                a[11] = a[13];
                a[12] = a[14];
                a[13] = a[15];
                a[14] = a[21];
                a[15] = a[20];
                a[21] = x;
                a[20] = y;
                z = a[16];
                a[16] = a[17];
                a[17] = a[19];
                a[19] = a[18];
                a[18] = z;
                break;
            case 7:
                x = a[8];
                y = a[9];
                a[8] = a[6];
                a[9] = a[7];
                a[6] = a[4];
                a[7] = a[5];
                a[4] = a[23];
                a[5] = a[22];
                a[23] = x;
                a[22] = y;
                z = a[0];
                a[0] = a[1];
                a[1] = a[3];
                a[3] = a[2];
                a[2] = z;
                break;
            case 8:
                x = a[14];
                y = a[15];
                a[14] = a[12];
                a[15] = a[13];
                a[12] = a[10];
                a[13] = a[11];
                a[10] = a[21];
                a[11] = a[20];
                a[21] = x;
                a[20] = y;
                z = a[16];
                a[16] = a[18];
                a[18] = a[19];
                a[19] = a[17];
                a[17] = z;
                break;
            case 9:
                x = a[2];
                y = a[3];
                a[2] = a[8];
                a[3] = a[14];
                a[8] = a[17];
                a[14] = a[16];
                a[16] = a[5];
                a[17] = a[11];
                a[5] = y;
                a[11] = x;
                z = a[6];
                a[6] = a[7];
                a[7] = a[13];
                a[13] = a[12];
                a[12] = z;
                break;
            case 10:
                x = a[0];
                y = a[1];
                a[0] = a[9];
                a[1] = a[15];
                a[9] = a[19];
                a[15] = a[18];
                a[18] = a[4];
                a[19] = a[10];
                a[4] = y;
                a[10] = x;
                z = a[20];
                a[20] = a[22];
                a[22] = a[23];
                a[23] = a[21];
                a[21] = z;
                break;
            case 11:
                x = a[2];
                y = a[3];
                a[2] = a[11];
                a[3] = a[5];
                a[5] = a[16];
                a[11] = a[17];
                a[16] = a[14];
                a[17] = a[8];
                a[14] = y;
                a[8] = x;
                z = a[6];
                a[6] = a[12];
                a[12] = a[13];
                a[13] = a[7];
                a[7] = z;
                break;
            case 12:
                x = a[0];
                y = a[1];
                a[0] = a[10];
                a[1] = a[4];
                a[4] = a[18];
                a[10] = a[19];
                a[18] = a[15];
                a[19] = a[9];
                a[15] = y;
                a[9] = x;
                z = a[20];
                a[20] = a[21];
                a[21] = a[23];
                a[23] = a[22];
                a[22] = z;
                break;
        }
//        System.out.println("operation:" + direction);
//        print(a);
//        print1(a);
        return a;
    }

    public static void print1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
    }

    public static int sum(int[] a) {
         return a[0] * a[1] * a[2] * a[3] +
                 a[4] * a[5] * a[10] * a[11] +
                 a[6] * a[7] * a[12] * a[13] +
                 a[8] * a[9] * a[14] * a[15] +
                 a[16] * a[17] * a[18] * a[19] +
                 a[20] * a[21] * a[22] * a[23] ;
    }


    private static int max = Integer.MIN_VALUE;

    public static void solve(int[] a, int step) {
        if (step <= 5) {
            int temp = sum(a);
//            max = Math.max(max, temp);
            if (temp > max) {
//                print(a);
                max = temp;
            }
        }else {
            return;
        }
        for (int i = 1; i <= 12; i++) {
            solve(operation(a, i), step + 1);
        }
    }

    public static int solution(int[] a) {
        max = Integer.MIN_VALUE;
        solve(a, 0);
        return max;
    }

    public static void print(int[] a) {
        System.out.printf("    %d %d\n" , a[0], a[1]);
        System.out.printf("    %d %d\n" , a[2], a[3]);
        for (int i = 4; i <= 9 ; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
        for (int i = 10; i <= 15 ; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
        System.out.printf("    %d %d\n" , a[16], a[17]);
        System.out.printf("    %d %d\n" , a[18], a[19]);
        System.out.printf("    %d %d\n" , a[20], a[21]);
        System.out.printf("    %d %d\n" , a[22], a[23]);
    }

    public static void main(String[] args) {
//        int[] a = new int[]{2,-3,-2,3,7,-6,-6,-7,9,-5,-9,-3,-2,1,4,-9,-1,-10,-5,-5,-10,-4,8,2};
//        print(a);
//        operation(a, 1);
//        operation(a, 2);
//        operation(a, 3);
//        operation(a, 4);
//        operation(a, 5);
//        operation(a, 6);
//        operation(a, 7);
//        operation(a, 8);
//        operation(a, 9);
//        operation(a, 10);
//        operation(a, 11);
//        operation(a, 12);
//        solve(new int[]{2,-3,-2,3,7,-6,-6,-7,9,-5,-9,-3,-2,1,4,-9,-1,-10,-5,-5,-10,-4,8,2}, 0);
//        System.out.println(max);
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = Integer.valueOf(nums[i]);
        }
        System.out.println(solution(a));
    }



}

