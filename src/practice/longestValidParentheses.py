# -*- coding: utf-8 -*- 
def longestValidParentheses(s: str) -> int:
        if len(s) < 2:
            return 0
        longest = - (1 << 60)
        stack = []
        indexStack = []
        dp = []
        for i in range(len(s)):
            dp.append(0)
            if s[i] == ')':
                if len(stack) > 0 and stack[-1] == '(':
                    # longest = max(longest, i - indexStack[-1] + 1)
                    dp[i] = dp[indexStack[-1] - 1] + i - indexStack[-1] + 1
                    longest = max(longest, dp[i])
                if len(stack) > 0:
                    stack.pop()
                    indexStack.pop()
            else:
                stack.append(s[i])
                indexStack.append(i)
        return longest if longest != - (1 << 60) else 0
        
print(longestValidParentheses("(()"))
print(longestValidParentheses(""))
print(longestValidParentheses("(()()"))
print(longestValidParentheses(")()())"))
print(longestValidParentheses("())))"))
print(longestValidParentheses("()(()"))
print(longestValidParentheses(")()())()()("))
print(longestValidParentheses(")())))))()"))
print(longestValidParentheses("(()(((()"))

# brackets  = input()
# print(longestValidParentheses(brackets))