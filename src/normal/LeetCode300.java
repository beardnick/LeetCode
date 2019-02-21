package normal;

public class LeetCode300 {

    public static int lengthOfLIS(int[] nums) {
        int[] a = new int[nums.length];
        int max;
        for (int i = 0; i < nums.length ; i++) {
            max = -1000000;
            for (int j = 0; j < i; j++) {
                if(a[j] > max && nums[j] < nums[i]){
                    max = a[j];
                }
            }
            a[i] = Math.max(max, 0) + 1;
        }
        max = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
