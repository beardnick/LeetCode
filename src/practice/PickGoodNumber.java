package practice;

import java.util.*;

public class PickGoodNumber {


    public static TreeMap<Integer, Integer> count ;

    public static TreeMap<Integer, TreeSet<Integer>> building ;

    public static TreeSet<Integer>  heightSet ;

    // TODO: 19-5-21 代码太丑了，重构一下 

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
//        Object[] heightList =  heightSet.toArray();
        int minist = Integer.MAX_VALUE;
        while (!building.isEmpty()) {
            Object[] last =  building.lastEntry().getValue().toArray();
            for (int i = last.length -1; i >= 0  ; i--) {
                int current = (Integer)last[i];
//                int start = Arrays.binarySearch(heightList, current);
                if (count.get(current) < number) {
                    int sum = 0;
                    int rest = number - count.get(current);
                    for (int j = current - 1, k = current + 1; j >= 0 && k <= 9 ; j--, k++) {
                        System.out.printf("current:%d\n", current);
//                        System.out.printf("height:%d\n",(Integer)heightList[j]);
                        if (count.containsKey(j) && count.containsKey(k)) {
                            if (count.get(j) + count.get(k) > rest) {
                                if (count.get(j) > count.get(k)) {
                                    if (count.get(j) < rest) {
                                        sum += ((current - j) * count.get(j));
                                        rest -= count.get(j);
                                    } else {
                                        sum += ((current - j) * rest);
                                        rest = 0;
                                        break;
                                    }
                                    if (count.get(k) < rest) {
                                        sum += (k - current) * count.get(k);
                                        rest -= count.get(k);
                                    } else {
                                        sum += ((k - current )* rest);
                                        rest = 0;
                                        break;
                                    }
                                } else {

                                    if (count.get(k) < rest) {
                                        sum += (k - current) * count.get(k);
                                        rest -= count.get(k);
                                    } else {
                                        sum += ((k - current) * rest);
                                        rest = 0;
                                        break;
                                    }

                                    if (count.get(j) < rest) {
                                        sum += (current - j) * count.get(j);
                                        rest -= count.get(j);
                                    } else {
                                        sum += ((current - j )* rest);
                                        rest = 0;
                                        break;
                                    }
                                }
                            }
                        } else if (count.containsKey(j)) {
                            if (count.get(j) < rest) {
                                sum += (current - j) * count.get(j);
                                rest -= count.get(j);
                            } else {
                                sum += ((current - j )* rest);
                                rest = 0;
                                break;
                            }

                        } else if (count.containsKey(k)) {
                            if (count.get(k) < rest) {
                                sum += (k - current) * count.get(k);
                                rest -= count.get(k);
                            } else {
                                sum += ((k - current) * rest);
                                rest = 0;
                                break;
                            }
                        }

                    }
                    if (rest != 0) {
                        continue;
                    }
                    minist = Math.min(minist, sum);
                    System.out.printf("minist:%d\n", minist);
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
        System.out.println(solution(5, new int[]{7,8,7,5,8,5}  ));
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int m = sc.nextInt();
//            int n = sc.nextInt();
//            char[] temp = sc.nextLine().toCharArray();
//            int[] a = new int[temp.length];
//            for (int i = 0; i < temp.length; i++) {
//                a[i] = temp[i] - '0';
//            }
//            System.out.println(solution(n, a));
//        }
    }

}
