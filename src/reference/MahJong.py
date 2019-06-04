# -*- coding: utf-8 -*- 
from collections import Counter

# #NOTE 2019-06-04 判断是否可以组成足够多的刻子和顺子
def fun(l):
    print("fun")
    print(l)
    # #NOTE 2019-06-04 如果是0就全部检查完了，是可以和牌
    if len(l) == 0:
        return True
        # #NOTE 2019-06-04 长度小于3了就不可能有刻子或者顺子了
    if len(l) < 3:
        return False
    d = Counter(l)
    ss = set(l)
    for e in ss:
        if d[e] >= 3:
            ll = []
            for k, v in d.items():
                ll.extend([k] * v) if k != e else l.extend([k] * (v - 3))
            if fun(ll):
                return True
        if (e in ss) and (e+1 in ss) and (e + 2 in ss):
            ll = []
            for k, v in d.items():
                ll.extend([k] * v) if k not in (e,e+1,e+2) else ll.extend([k] * (v - 1))
            if fun(ll):
                return True
    return False
 
 
 
nums = list(map(int, input().split()))
 
d = Counter(nums)
 
 
for i in range(1,10):
    # #NOTE 2019-06-04 统计每种牌使用的次数，如果使用了四次了就不能再使用了
    if d[i] == 4:
        continue
    d[i] += 1
    sign = False
    # #NOTE 2019-06-04 所有已经使用的数字的集合
    ss = set(d.keys())
    for e in ss:
        # #NOTE 2019-06-04 数字的数量大于2就可以组一个雀头
        if d[e] >= 2:
            l = []
            for k,v in d.items():
                print(e)
                print(k)
                # #NOTE 2019-06-04 [k] * v会形成v个k的数组
                # 一种特殊的if语句写法，前面的第一条语句是if成立时执行的
                l.extend([k] * v) if k != e else l.extend([k] * (v-2))
               # #NOTE 2019-06-04 这里拿e作为雀头
            if fun(l):
                sign = True
                break
    if sign:
        print(i)
    d[i] -= 1