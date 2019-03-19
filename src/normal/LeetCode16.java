package normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LeetCode16 {
    public static int threeSumClosest(int[] nums, int target) {
        int min = 1000000 , res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length ; k++) {
                    int tmp = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    if(tmp < min){
                        min = tmp;
                        res = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
               LeetCode16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)
        );
        System.out.println(
                LeetCode16.threeSumClosest(new int[]{0, 0, 0}, 1)
        );
    }
}
