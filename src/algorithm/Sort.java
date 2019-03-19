package algorithm;

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


    public static void main(String[] args) {
        List<Comparable> list = Arrays.asList(5, 1, 2, 8, 3, 6, 9);
//        quickSort(list,0, list.size() - 1);
//        loopQuickSort(list, 0, list.size() - 1);
        mergeSort(list,0, list.size() - 1);
        System.out.println(list);
    }
}
