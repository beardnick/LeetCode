package hard;

public class LeetCode4{

        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            boolean isEven = (nums1.length + nums2.length ) % 2 == 0;
            int halfSize;
            if(isEven){
                halfSize = (nums1.length + nums2.length) / 2 - 1;
            }else {
                halfSize = (nums1.length + nums2.length) / 2;
            }
            if(nums1.length == 0 || nums2.length == 0){
                if(nums2.length == 0){
                    return isEven ? ((double)nums1[nums1.length / 2] + (double)nums1[nums1.length / 2 -1]) / 2: (double) nums1[nums1.length / 2];
                }else {
                    return isEven ? ((double)nums2[nums2.length / 2] + (double)nums2[nums2.length / 2 -1]) / 2: (double) nums2[nums2.length / 2];
                }
            }
            int left = 0, right = nums1.length, index1 = (left + right) / 2;
            int index2 = 0;
            while (left < right &&
                    halfSize - (left + right) / 2 >= 0 &&
                    halfSize - (left + right) / 2 <= nums2.length - 1 ){
                index1 = (left + right ) / 2;
                index2 = halfSize - index1;
//            if(halfSize - index1 < 0 || halfSize - index1 > nums2.length - 1)break;
//            if(index2 > nums2.length - 1)break;
                if((index2 == 0 || nums1[index1] >= nums2[index2 - 1]) &&
                        (index1 == 0 || nums2[index2] >= nums1[index1 - 1])){
                    break;
                }else if(index2 != 0 && nums1[index1] < nums2[index2 - 1] ) {
                    left = index1 + 1;
                }else {
                    right = index1;
                }
            }
            double a , b;
            if(left >= right ||
                    halfSize - (left + right) / 2 < 0 ||
                    halfSize - (left + right) / 2 > nums2.length - 1 ){
                if(nums1.length > nums2.length){
                    if(nums2[index2] < nums1[index1]){
                        a = (double)nums1[index1 - 1];
                        b = (double)nums1[index1];
                    }else{
                        a = (double)nums1[index1];
                        b = (double)nums1[index1 + 1];
                    }
                }else{
                    if(nums1[index1] < nums2[index2]) {
                        a = (double)nums2[index2 - 1];
                        b = (double)nums2[index2];
                    }else{
                        a = (double)nums2[index2];
                        b = (double)nums2[index2 + 1];
                    }
                }
            }else {
                a = (double)nums1[index1];
                b = (double)nums2[index2];
            }
            if(isEven){
                return (a + b) / 2;
            }else {
                return Math.min(a, b);
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
