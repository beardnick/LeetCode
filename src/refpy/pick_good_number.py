# -*- coding: utf-8 -*-
import math
import copy
# #NOTE 2019-05-23 a为原靓号序列，k为当前选择的基准数字，n剩下的数
def repone(a, k, n):
    # #NOTE 2019-05-23 python深拷贝
    res = copy.deepcopy(a)
    cost = 0
    p=1
    t = 0
    while p:
        # #NOTE 2019-05-23 两次循环分别求abs(x - k) == p的值的代价之和
        for i in range(len(a)):
            if t == n:
                break
            if a[i]-k == p :
                # #NOTE 2019-05-23 res保存最终靓号结果
                res[i] = k
                t += 1
                cost +=p

        for j in range(len(a)):
            if t == n:
                break
            if k-a[len(a)-j-1] == p :
                res[len(a)-j-1] = k
                t += 1
                cost +=p
        p+=1
        if t == n:
            break
    return cost,res

if __name__ == "__main__":
    N,K = list(map(int,input().split(" ")))
    s = input()
    num = list(map(int,list(s)))
    # #NOTE 2019-05-23 得到唯一的排序后的数字
    w_num = list(sorted(list(set(num))))
    res = []
    cost = []
    for val in w_num:
        # #NOTE 2019-05-23 如果已经是靓号了直接返回0就可以了
        if num.count(val) >= K:
            res = [num]
            cost = [0]
            break
        c,o = repone(num, val, K-num.count(val))
        #print(c,o)
        # #NOTE 2019-05-23 典型的空间换时间，把所有结果保存下来，最后再统一比较
        res.append(o)
        cost.append(c)

    index = cost.index(min(cost))
    print(cost[index])
    ss = list(map(str, res[index]))
    print("".join(ss))