package practice;


import java.util.*;

// 容斥定理
public class InclusionExclusionPrinciple {




//    要计算几个集合并集的大小，我们要先将所有单个集合的大小计算出来，
//    然后减去所有两个集合相交的部分，再加回所有三个集合相交的部分，
//    再减去所有四个集合相交的部分，依此类推，一直计算到所有集合相交的部分。

    public static Set<Integer> tmp;

    public static Set<Integer>[] setArray;

    public static  int total;

    public static   void dfs(int cur, int index, int n){
        if (index > n + 1) {
            return;
        }
        if (n + 1 == index) {
            total += tmp.size();
            return;
        }
        for (int i = cur; i < setArray.length; i++) {
            if (index == 1) {
                tmp = setArray[i];
            }
            Set<Integer> oldTmp = new HashSet<>();
            oldTmp.addAll(tmp);
            tmp.retainAll(setArray[i]);
//            System.out.println("[" + cur +" " + i + "] :" + n);
//            System.out.println(tmp);
            dfs(i + 1, index + 1, n);
            tmp.addAll(oldTmp);
        }
    }

     public static <Integer> int solution(Set<Integer>... s){
        int res = 0;
         setArray = (Set<java.lang.Integer>[]) s;
         for (int i = 1; i <= s.length ; i++) {
             total = 0;
             dfs(0, 1, i);
             res += (Math.pow(-1, i - 1) * (total));
         }
         return res;
    }


    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> b = new HashSet<>(Arrays.asList(4, 2, 1));
        HashSet<Integer> c = new HashSet<>(Arrays.asList(1, 6, 3));
        HashSet<Integer> d = new HashSet<>(Arrays.asList(1, 6, 8));
        HashSet<Integer> e = new HashSet<>(Arrays.asList(0, 6, 3));
        HashSet<Integer> f = new HashSet<>(Arrays.asList(1, 7, 3));
        HashSet<Integer> g = new HashSet<>(Arrays.asList(1, 6, 3));
//        Set[] arr = new HashSet[]{a, b, c};
//        setArray = (Set<Integer>[])arr;
//        InclusionExclusionPrinciple.dfs(0, 1,  3);
//        System.out.println(total);
        System.out.println(solution(a, b , c,d,e,f,g));
    }


}
