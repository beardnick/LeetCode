package practice;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class PickGoodNumber {


    public static  int solution(int n, int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        TreeSet<Integer> nums = new TreeSet<>();
        for (int x : arr) {
            nums.add(x);
            if (count.containsKey(x)) {
                count.put(x, count.get(x) + 1);
            } else {
                count.put(x, 1);
            }
        }
        TreeMap<Integer, Integer> res = new TreeMap<>();
        for (int x : nums.descendingSet()) {
            if (count.get(x) >= n) {
                return 0;
            } else {
                int sub = 1;
                int rest = n - count.get(x);
                int cost = 0;
                while (rest != 0) {
                    int f = 0;
                    if (count.containsKey(x + sub)) {
                        f += count.get(x + sub);
                    }
                    if (count.containsKey(x - sub)) {
                        f += count.get(x - sub);
                    }
                    System.out.println( "x:" + x + "rest:" + rest + " " + "f:" + f );
                    if (f >= rest) {
                        cost += rest * sub;
                        break;
                    } else {
                        rest -= f;
                        cost += f * sub;
                    }
                    if (res.size() != 0 && cost > res.firstEntry().getKey()) {
                        break;
                    }
                    sub++;
                    if (sub >= 10) {
                        break;
                    }
                }
                res.put(cost, x);
            }
        }
        int sub = 1;
        int rest = n - count.get(res.firstEntry().getValue());
        int x = res.firstEntry().getValue();
        while (rest != 0) {
            //                    由大改小从前往后,保证字典序最小
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] - sub == x) {
                    arr[i] = x;
                    //                            System.out.println("sub:" + sub + " " + Arrays.toString(tmp));
                    if ((--rest) == 0) {
                        break;
                    }
                }
            }
            //                    由小改大从后往前,保证字典序最小
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] + sub == x) {
                    arr[i] = x;
                    //                            System.out.println("sub:" + sub + " " + Arrays.toString(tmp));
                    if ((--rest) == 0) {
                        break;
                    }
                }
            }
            sub ++;
            if (sub >= 10) {
                break;
            }
        }
        return res.firstKey();
    }


            public static void main (String[]args){
//        5 3
//        1 1 2 3 3
//        Map.Entry<Integer, int[]> res = solution(5, new int[]{7, 8, 7, 5, 8, 5});
//        System.out.println(res.getKey());
//        System.out.println(Arrays.toString(res.getValue()));
                Scanner sc = new Scanner(System.in);
                while (sc.hasNext()) {
                    int m = sc.nextInt();
                    int n = sc.nextInt();
            System.out.println("m:" + m + "n:" + n);
                    char[] temp = sc.next().toCharArray();
                    int[] a = new int[temp.length];
                    for (int i = 0; i < temp.length; i++) {
                        a[i] = temp[i] - '0';
                    }
                    System.out.println(solution(n, a));
                    final StringBuilder sb = new StringBuilder();
                   for (int x : a) {
                        sb.append("" + x);
                    }
                    System.out.println(sb.toString());
                }
            }
        }
