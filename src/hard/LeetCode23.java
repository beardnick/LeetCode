package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

import util.ListNode;

public class LeetCode23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        Vector<ListNode> vector = new Vector<>();
        for (ListNode node:
             lists) {
            while (node != null){
                vector.add(node);
                node = node.next;
            }
        }
        vector.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode result = new ListNode(0);
        ListNode p = result;
        for (ListNode node:
             vector) {
            p.next = node;
            p = node;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);
        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);
        System.out.println(
                LeetCode23.mergeKLists(
                        new ListNode[]{n1, n2, n3}
                )
        );
    }
}
