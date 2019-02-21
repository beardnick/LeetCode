package normal;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {

    public static int lengthOfLongestSubstring(String s){
        Set<Character> setCur = new HashSet<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length() ; end++) {
            if(setCur.contains(s.charAt(end))){
                max = Math.max(max, setCur.size());
                setCur.remove(s.charAt(start));
                end --;
                start ++;
            }else {
                setCur.add(s.charAt(end));
            }
        }
        return Math.max(max, setCur.size());
    }

    public static void main(String[] args) {
        System.out.println(
                LeetCode3.lengthOfLongestSubstring("pwwkew")
        );
        System.out.println(
                LeetCode3.lengthOfLongestSubstring("bbbb")
        );
        System.out.println(
                LeetCode3.lengthOfLongestSubstring("abcdefgacd")
        );



    }
}
