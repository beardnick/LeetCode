package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class SaveWater {

//    没有考虑到两个极值之间还夹了一个较小的极值的情况
//    public static int trap(int[] height) {
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//        int left = -1;
//        int right = -1;
//        int result = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (( i - 1 == -1 || height[i] >= height[i - 1]) && ( i + 1 == height.length || height[i] >= height[i + 1] )) {
//                left = right;
//                right = i;
//                if (left != -1 && right != -1) {
//                    int sum = 0;
//                    int min = Math.min(height[left], height[right]);
//                    for (int j = left + 1; j < right ; j++) {
//                        if (height[j] <= min) {
//                            sum += height[j];
//                        } else {
//                            sum += min;
//                        }
//                    }
//                    result += (min * (right - left - 1) - sum);
//                }
//            }
//        }
//        return result;
//    }


    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        ArrayList<Integer> tops = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (( i - 1 == -1 || height[i] >= height[i - 1]) && ( i + 1 == height.length || height[i] >= height[i + 1] )) {
                tops.add(i);
            }
        }
//        boolean sizeChanged = true;
//        while (sizeChanged) {
//            sizeChanged = false;
        System.out.println("tops:" + tops);
            for (int i = 1; i < tops.size() - 1; i++) {
                if (height[tops.get(i)] < height[tops.get(i - 1)] && height[tops.get(i)] < height[tops.get(i + 1)]) {
                    tops.remove(i);
//                    sizeChanged = true;
                    i = (i == 1 ? i - 1 : i - 2);
                }
            }
//        }

        System.out.println("tops:" + tops);
        for (int i = 0; i < tops.size() - 1 ; i++) {
            int left = tops.get(i);
            int right = tops.get(i + 1);
            int sum = 0;
            int min = Math.min(height[left], height[right]);
            for (int j = left + 1; j < right ; j++) {
                if (height[j] <= min) {
                    sum += height[j];
                } else {
                    sum += min;
                }
            }
            result += (min * (right - left - 1) - sum);
        }
        return result;
    }
    public static void main(String[] args) {
//        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) == 6);
//        System.out.println(trap(new int[]{1,0,2,1,0,1,3,2,1,2}) == 6);
//        System.out.println(trap(new int[]{2,1,0,1,3,2,1,2,1}) == 5);
//        System.out.println(trap(null) == 0);
//        System.out.println(trap(new int[]{1,1,1}) == 0);
//        System.out.println(trap(new int[]{3, 2, 0, 1, 4, 6}) == 6);
//        System.out.println(trap(new int[]{4, 0, 2, 0, 4}) == 10);
        System.out.println(trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}) == 83);
    }
}
