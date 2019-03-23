package algorithm;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sort {

    private static int partition(List<Comparable> list, int left, int right){
        Comparable x = list.get(left);
        int begin = left;
        int end = right;
        while (begin < end) {
            while (begin < end && list.get(end).compareTo(x) > 0) {
                end--;
            }
            if (begin < end) {
                list.set(begin, list.get(end));
            }
            begin++;
            while (begin < end && list.get(begin).compareTo(x) <= 0) {
                begin++;
            }
            if (begin < end) {
                list.set(end, list.get(begin));
            }
            end --;
        }
        list.set(begin, x);
        return begin;
    }

    public static void quickSort(List<Comparable> list, int left, int right){
        if(left > right || left < 0 || right > list.size() - 1){
            return;
        }
        int mid = partition(list, left, right);
        quickSort(list,left, mid - 1);
        quickSort(list,mid + 1, right);
    }

    public static void loopQuickSort(List<Comparable> list, int left, int right) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(left);
        stack.addLast(right);
        while (!stack.isEmpty()) {
            right = stack.removeLast();
            left = stack.removeLast();
            if(left > right || left < 0 || right > list.size() - 1){
                return;
            }
            int mid = partition(list, left, right);

            stack.addLast(mid + 1);
            stack.addLast(right);

            stack.addLast(left);
            stack.addLast(mid - 1);
        }
    }

    private static void  merge(List<Comparable>list, int left, int mid, int right) {
        int i = left, j = mid + 1;
        List<Comparable> temp = new ArrayList<>(right - left + 1);
        while (i <= mid && j <= right) {
            if ( list.get(i).compareTo(list.get(j)) < 0) {
                temp.add(list.get(i ++));
            }else {
                temp.add(list.get(j ++));
            }
        }
        while (i <= mid) {
            temp.add(list.get(i ++));
        }
        while (j <= right) {
            temp.add(list.get(j ++));
        }
        for (Comparable e : temp) {
            list.set(left ++, e);
        }
    }

    public static void mergeSort(List<Comparable> list, int left, int right){
        if (left >= right || left < 0 || right > list.size() - 1) {
            return;
        }
        int mid = (right - left) / 2  + left;
        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    public static int recursionBinarySearch(List<Comparable> list, int left, int right, Comparable key) {
//        System.out.println("left:" + left + " right:" + right);
        if ( key.compareTo(list.get(left)) < 0 ||
                key.compareTo(list.get(right)) > 0 ||
        left >= right) {
            if (key.equals(list.get(left))) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (right - left) / 2 + left;
        if (key.compareTo(list.get(mid)) <= 0) {
            return recursionBinarySearch(list, left, mid, key);
        }else {
            return  recursionBinarySearch(list, mid + 1, right,  key);
        }
    }

    public static int binarySearch(List<Comparable> list, int left, int right, Comparable key) {
        while (left < right && key.compareTo(list.get(left)) >= 0 && key.compareTo(list.get(right)) <= 0) {
            int mid = (right - left ) /2 + left;
            if (key.compareTo(list.get(mid)) <= 0) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if (key.equals(list.get(left))) {
            return left;
        } else {
            return  -1;
        }
    }


public static void main(String[] args) {
        List<Comparable> list = Arrays.asList(5, 1, 2, 8, 3, 6, 9, 1, 2 , 2);
//        quickSort(list,0, list.size() - 1);
//        loopQuickSort(list, 0, list.size() - 1);
        mergeSort(list,0, list.size() - 1);
        System.out.println(list);
        System.out.println(recursionBinarySearch(list, 0, list.size() - 1, 5));
        System.out.println(recursionBinarySearch(list, 0, list.size() - 1, 7));
        System.out.println(recursionBinarySearch(list, 0, list.size() - 1, 2));
        System.out.println(binarySearch(list, 0, list.size() - 1, 5));
        System.out.println(binarySearch(list, 0, list.size() - 1, 7));
        System.out.println(binarySearch(list, 0, list.size() - 1, 2));
    }
}
