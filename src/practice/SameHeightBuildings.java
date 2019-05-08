package practice;

import java.util.*;

public class SameHeightBuildings {

    public static TreeMap<Integer, Integer> count ;

    public static TreeMap<Integer, TreeSet<Integer>> building ;

    public static TreeSet<Integer>  heightSet ;

    public static int solution(int number, int[] heights) {
        count = new TreeMap<>();
        building = new TreeMap<>();
        heightSet = new TreeSet<>();
        for (int i = 0; i < heights.length; i++) {
            heightSet.add(heights[i]);
            if (count.containsKey(heights[i])) {
                count.put(heights[i], count.get(heights[i]) + 1);
            } else {
                count.put(heights[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> x:
                count.entrySet()) {
            if (building.containsKey(x.getValue())) {
                building.get(x.getValue()).add(x.getKey());
            } else {
                TreeSet<Integer> tmp = new TreeSet<>();
                tmp.add(x.getKey());
                building.put(x.getValue(), tmp);
            }
        }
        Object[] heightList =  heightSet.toArray();
        int minist = Integer.MAX_VALUE;
        while (!building.isEmpty()) {
            Object[] last =  building.lastEntry().getValue().toArray();
            for (int i = last.length -1; i >= 0  ; i--) {
                int current = (Integer)last[i];
                int start = Arrays.binarySearch(heightList, current);
                if (count.get(current) < number) {
                    int sum = 0;
                    int rest = number - count.get(current);
                    for (int j = start - 1; j >= 0 ; j--) {
//                        System.out.printf("height:%d\n",(Integer)heightList[j]);
                        if (count.get(heightList[j]) < rest) {
                            sum += ((current - (Integer)heightList[j]) * count.get(heightList[i]));
                            rest -= count.get(heightList[i]);
                        }else{
                            sum += ((current - (Integer)heightList[j])  * rest);
                            rest = 0;
                            break;
                        }
                    }
                    if (rest != 0) {
                        continue;
                    }
                    minist = Math.min(minist, sum);
//                    System.out.printf("minist:%d\n", minist);
                } else {
                    return 0;
                }
            }
            building.remove(building.lastKey());
        }
        return minist;
    }



    public static void main(String[] args) {
//        5 3
//        1 1 2 3 3
//        System.out.println(solution(3, new int[]{1, 1, 2, 3, 3}));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(solution(n, a));
        }
    }

}
