import java.util.Stack;

public class Solution {

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        // #NOTE 2019-06-04 栈中只留下了还没有匹配到的坐标，那么坐标后面的就
        // 都已经匹配到了，这时候只需要使用i - stack.peek()就行了
        // 官方解答还是厉害呀
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main (String[] args) {
        System.out.println( longestValidParentheses("()()()))()"));
    }
}
