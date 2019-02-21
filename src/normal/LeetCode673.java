package normal;

public class LeetCode673 {

    public static int findNumberOfLIS(int[] nums) {
        int[] a = new int[nums.length];
        int[] n = new int[nums.length];
        int max = -1000000, maxNum = 1;
        for (int i = 0; i < nums.length ; i++) {
            max = -1000000;
            maxNum = 1;
            for (int j = 0; j < i; j++) {
                if(a[j] > max && nums[j] < nums[i]){
                    max = a[j];
                    maxNum = n[j];
                }else  if(a[j] == max && nums[j] < nums[i]){
                    maxNum += n[j];
                }
            }
            a[i] = Math.max(max, 0) + 1;
            n[i] = maxNum;
        }
        max = - 10000;
        maxNum = 0;
//        for (int x:
//             a) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
//        for (int x:
//                n) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
        for (int i = 0; i < nums.length ; i++) {
            if(a[i] > max){
                max = a[i];
                maxNum = n[i];
            }else if(a[i] == max){
                maxNum += n[i];
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(
                LeetCode673.findNumberOfLIS(new int[]{2, 2, 2, 2, 2})
        );
        System.out.println(
                LeetCode673.findNumberOfLIS(new int[]{1, 3, 5, 4, 7})
        );
        System.out.println(
                LeetCode673.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7,2})
        );
        System.out.println(
                LeetCode673.findNumberOfLIS(
                        new int[]{1,1,1,2,2,2,3,3,3}
                )
        );
    }

}
