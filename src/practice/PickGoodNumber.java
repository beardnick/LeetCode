package practice;

import java.util.*;
import java.util.stream.Stream;

public class PickGoodNumber {




    public static Map.Entry<Integer, int[]> solution(int n, int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> nums = new HashSet<>();
        for (int x : arr) {
            nums.add(x);
            if (count.containsKey(x)) {
                count.put(x, count.get(x) + 1);
            } else {
                count.put(x, 1);
            }
        }
        TreeMap<Integer, int[]> res = new TreeMap<>();
        for (int x : arr) {
            if (count.get(x) >= n) {
                res.put(0, arr);
                return res.firstEntry();
            } else {
                int sub = 1;
                int rest = n - count.get(x);
                int cost = 0;
                int[] tmp = Arrays.copyOf(arr, arr.length);
                while (rest != 0) {
//                    由大改小从前往后,保证字典序最小
                    for (int i = 0; i < arr.length; i++) {
                        if (tmp[i] - sub == x) {
                            tmp[i] = x;
                            cost += sub;
//                            System.out.println("sub:" + sub + " " + Arrays.toString(tmp));
                            if ((--rest) == 0) {
                                break;
                            }
                        }
                    }

//                    由小改大从后往前,保证字典序最小
                    for (int i = arr.length - 1; i >= 0; i--) {
                        if (tmp[i] + sub == x) {
                            tmp[i] = x;
                            cost += sub;
//                            System.out.println("sub:" + sub + " " + Arrays.toString(tmp));
                            if ((--rest) == 0) {
                                break;
                            }
                        }
                    }

                    sub ++;
                }
                res.put(cost, tmp);
            }
        }
        return res.firstEntry();
    }



    public static void main(String[] args) {
//        5 3
//        1 1 2 3 3
//        Map.Entry<Integer, int[]> res = solution(5, new int[]{7, 8, 7, 5, 8, 5});
//        System.out.println(res.getKey());
//        System.out.println(Arrays.toString(res.getValue()));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
//            System.out.println("m:" + m + "n:" + n);
            char[] temp = sc.next().toCharArray();
            int[] a = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                a[i] = temp[i] - '0';
            }
//            System.out.println(Arrays.toString(a));
        Map.Entry<Integer, int[]> res = solution(n, a);
            System.out.println(res.getKey());
            final  StringBuilder sb = new StringBuilder();
            for (int x :
                    res.getValue()) {
                sb.append("" + x);
            }
            System.out.println(sb.toString());
        }
    }
}
