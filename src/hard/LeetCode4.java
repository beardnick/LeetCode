package hard;

public class LeetCode4{

        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length == 0) {
                return -1;
            }
            if (nums2.length == 0) {
                if (nums1.length % 2 == 0) {
                    return (double)(nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2;
                } else {
                    return nums1[nums1.length / 2];
                }

            }
            if(nums2.length > nums1.length){
                return findMedianSortedArrays(nums2, nums1);
            }
            int half = nums2.length + (nums1.length - nums2.length) / 2;
            int left = 0;
            int right = nums2.length;
//            int k2 = left + (right - left) / 2;
//            int k1 = half / 2 - k2;
//            System.out.println("half:" + half);
            int k1 = 0, k2 = 0;
            while (left < right) {
                k2 = left + (right - left) / 2;
                k1 = half - 1 - k2;
//                System.out.println("left:" + left + " " + "right:" + right);
//                System.out.println("k1:" + k1 + " " + "k2:" + k2);
                if (nums1[k1] < nums2[k2]) {
                    right = k2 ;
                } else {
                    left = k2 + 1;
                }
            }
            if ((nums1.length + nums2.length) % 2 == 0) {
                if (nums1[k1] >= nums2[k2]) {
                    int low = Math.max((k1 - 1 >= 0 && k1 - 1 < nums1.length) ? nums1[k1 - 1] : Integer.MIN_VALUE,
                            (k2 >= 0 && k2 < nums2.length) ? nums2[k2] : Integer.MIN_VALUE);
                    int high = Math.min((k1 >= 0 && k1 < nums1.length) ? nums1[k1] : Integer.MAX_VALUE,
                            (k2 + 1 >= 0 && k2 + 1 < nums2.length) ? nums2[k2 + 1] : Integer.MAX_VALUE);
                    return ((double) low + (double) high) / 2;
                } else {
                    int low = Math.max((k2 - 1 >= 0 && k2 - 1 < nums2.length) ? nums2[k2 - 1] : Integer.MIN_VALUE,
                            (k1 >= 0 && k1 < nums1.length) ? nums1[k1] : Integer.MIN_VALUE);
                    int high = Math.min((k2 >= 0 && k2 < nums2.length) ? nums2[k2] : Integer.MAX_VALUE,
                            (k1 + 1 >= 0 && k1 + 1 < nums1.length) ? nums1[k1 + 1] : Integer.MAX_VALUE);
                    return ((double) low + (double) high) / 2;
                }
            }else{
                if (nums1[k1] >= nums2[k2]) {
                    return Math.min((k1 >= 0 && k1 < nums1.length) ? nums1[k1] : Integer.MAX_VALUE,
                            (k2 + 1 >= 0 && k2 + 1 < nums2.length) ? nums2[k2 + 1] : Integer.MAX_VALUE);
                } else {
                    return Math.min((k2 >= 0 && k2 < nums2.length) ? nums2[k2] : Integer.MAX_VALUE,
                            (k1 + 1 >= 0 && k1 + 1 < nums1.length) ? nums1[k1 + 1] : Integer.MAX_VALUE);
                }

                }

        }

    public static void main(String[] args) {
        System.out.println(LeetCode4.findMedianSortedArrays(new int[]{1} , new int[]{1 , 2 , 3 , 4}));
        System.out.println(LeetCode4.findMedianSortedArrays(new int[]{1 , 2 , 3 , 4}, new int[]{1}));
        System.out.println(LeetCode4.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(LeetCode4.findMedianSortedArrays(new int[]{1, 2, 3} , new int[]{1 , 2 , 3 , 4}));
        System.out.println(LeetCode4.findMedianSortedArrays(new int[]{1, 3} , new int[]{2}));
        System.out.println(LeetCode4.findMedianSortedArrays(new int[]{1, 2} , new int[]{3 , 4}));
        System.out.println(LeetCode4.findMedianSortedArrays(new int[]{1, 5, 6, 7, 8, 10} , new int[]{2, 3, 4, 9, 11}));
    }
}
