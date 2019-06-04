# -*- coding: utf-8 -*- 
def longestValidParentheses(s: str) -> int:
        # stack = list(str)
        stack = []
        longest = -(1<<60)
        thiscnt = 0
        lastcnt = 0
        for i in s:
            if i == ')':
                if len(stack) > 0 and stack[-1] == '(':
                    stack.pop()
                    thiscnt += 1
                # else:
                #     longest = max(longest,cnt)  - len(stack)
                #     stack = []
                #     cnt = 0
                if len(stack) != 0:
                    longest = max(longest, thiscnt - len(stack))
                else:
                    longest = max(thiscnt + lastcnt, longest)
                # print("len of stack :" , len(stack))
                # print("thiscnt :" , thiscnt)
                # print("lastcnt :" , lastcnt)
                # print("longest :" , longest)
                lastcnt = thiscnt - len(stack)
                stack = []
                thiscnt = 0
            else:
                stack.append(i)
                thiscnt +=1
        # print("len of stack :" , len(stack))
        # print("thiscnt :" , thiscnt)
        # print("lastcnt :" , lastcnt)
        # print("longest :" , longest)
        if len(stack) != 0:
            longest = max(longest, thiscnt - len(stack))
        else:
            longest = max(thiscnt + lastcnt, longest)
        return longest
                 
print(longestValidParentheses("(()"))
print(longestValidParentheses("(()()"))
print(longestValidParentheses(")()())"))
print(longestValidParentheses("())))"))
print(longestValidParentheses("()(()"))
print(longestValidParentheses(")()())()()("))
print(longestValidParentheses(")())))))()"))
print(longestValidParentheses("(()(((()"))

# brackets  = input()
# print(longestValidParentheses(brackets))