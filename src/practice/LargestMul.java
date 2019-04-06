package practice;

import java.util.PriorityQueue;

public class LargestMul {

    public static long solve(long[] a) {
        if (a.length < 3) {
            return 0;
        }
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(a[0]);
        queue.add(a[1]);
        queue.add(a[2]);

    }

    public static void main(String[] args) {

    }
}
