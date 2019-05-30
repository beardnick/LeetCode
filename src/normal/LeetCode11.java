package normal;

import java.util.Arrays;

public class LeetCode11 {

    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    public static int maxLen(int index, int start, int end, int[] height) {
//        if (start == end) {
//            return -1;
//        }
        int value = height[index];
        int temp = -1;
        if (start < end) {
            for (int i = start; i <= end; i++) {
                if (height[i] >= value) {
                    temp = i;
                }
            }
        } else {
            for (int i = start; i >= end; i--) {
//                System.out.println("maxLen:" + i + "temp:" + temp);
                if (height[i] >= value) {
                    temp = i;
                }
            }
        }
        return index == temp ? -1 : temp;
    }

    public static int minLen(int index, int start, int end, int[] height) {
//        if (start == end) {
//            return -1;
//        }
        int value = height[index];
        int temp = -1;
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                if (height[i] >= value) {
                    temp = i;
                    break;
                }
            }
        } else {
            for (int i = start; i >= end; i--) {
                if (height[i] >= value) {
                    temp = i;
                    break;
                }
            }
        }
        return index == temp ? -1 : temp;
    }


    public static int maxAreaNew(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            if (i > 0 && left[i - 1] != -1) {
                if (height[i] > height[i - 1]) {
                    left[i] = minLen(i, left[i - 1], i + 1, height);
                } else if (height[i] < height[i - 1]) {
                    left[i] = maxLen(i, left[i - 1], height.length - 1, height);
                } else {
                    left[i] = left[i - 1];
                }
            } else {
                left[i] = maxLen(i, i, height.length - 1, height);
            }
//            System.out.println("left:" + Arrays.toString(left));
        }

        for (int i = height.length - 1; i >= 0; i--) {
            if (i < height.length - 1 && right[i + 1] != -1) {
                if (height[i] > height[i + 1]) {
                    right[i] = minLen(i, right[i + 1], i , height);
                } else if (height[i] < height[i + 1]) {
                    right[i] = maxLen(i, right[i + 1], 0, height);
                } else {
                    right[i] = right[i + 1];
                }
            } else {
                right[i] = maxLen(i, i, 0, height);
            }
//            System.out.println("index: " + i + "right:" + Arrays.toString(right));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (left[i] != -1 && (left[i] - i) * height[i] > max) {
                max = (left[i] - i) * height[i];
            }
        }
        for (int i = height.length - 1; i >= 0; i --) {
            if (right[i] != -1 && (i - right[i]) * height[i] > max) {
                max = (i - right[i]) * height[i];
            }
        }
        return max;
    }

    public static int maxAreaBetter(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[j] < height[i]) {
                j--;
            } else {
                i ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaBetter(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
//        System.out.println(maxArea(new int[]{1,6,2,5,4,8,3,7}));
//        System.out.println(maxArea(new int[]{1, 2}));
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
