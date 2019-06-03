package practice;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PatternExtract {


    public static HashMap<Integer, HashMap<Integer, Integer>> counter = new HashMap<>();

    public static void setIfAbsent(int first, int second, HashMap<Integer, HashMap<Integer, Integer>> map) {
        if (map.containsKey(first)) {
            if (map.get(first).containsKey(second)) {
                return;
            } else {
                map.get(first).put(second, 0);
            }
        } else {
            HashMap<Integer, Integer> temp = new HashMap<>();
            temp.put(second, 0);
            map.put(first, temp);
        }
    }

    public static Integer getHashMap(int first, int second, HashMap<Integer, HashMap<Integer, Integer>> map) {
        setIfAbsent(first, second, map);
        return map.get(first).get(second);
    }


    public static void setHashMap(int first, int second, int value, HashMap<Integer, HashMap<Integer, Integer>> map) {
        setIfAbsent(first, second, map);
        map.get(first).put(second, value);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int max = Integer.MIN_VALUE;
            int m = sc.nextInt();
            HashMap<Integer, HashMap<Integer, Integer>> appearLastFrame = new HashMap<>();
            while (m-- > 0) {
                HashMap<Integer, HashMap<Integer, Integer>> appearThisFrame = new HashMap<>();
                int c = sc.nextInt();
                while (c-- > 0) {
                    int first = sc.nextInt();
                    int second = sc.nextInt();
//                    counter[first][second] ++;
                    setHashMap(first,second,1,appearThisFrame);
                    if (getHashMap(first, second, appearLastFrame) == 0) {
                        setHashMap(first,second,0,counter);
                    }
                    setHashMap(first,second,getHashMap(first,second,counter) + 1, counter);
                    max = Math.max(getHashMap(first, second, counter), max);
//                    System.out.println("counter:" + counter);
                }
                appearLastFrame = appearThisFrame;
            }
            System.out.println(max);
        }
    }
}
