package hard;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import util.ListNode;

public class LeetCode25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode p1, p2, p3, h1, h2 = null, res = head;
        for (int i = 0; i < k - 1 && res.next != null; i++) {
            res = res.next;
        }
        h1 = head;
        p1 = head;
        p2 = p1.next;
        if (p2 == null) return head;
        p3 = p2.next;
//        if(p3 == null && k >= 2){
//            p2.next = p1;
//            p1.next = null;
//            return head;
//        }else if(p3 == null){
//            return head;
//        }
        int i;
        do {
            for (i = 0; i < k - 1 && p3 != null; i++) {
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
            }
            if (h2 != null) {
                if (i == k - 1) {
                    h1.next = p1;
                }else {
                    h1.next = p2;
                }
                h1 = h2;
            }
            if (i == k - 1 && p3 == null) {
                h1.next = p2;
                break;
            } else if (i != k - 1) {
                h1.next = null;
                p2.next = p1;
                break;
            }
//            h2 = p1.next;
            h2 = p2;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        } while (true);
        return res;
    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null) return null;
        ListNode p1, p2, p3, h1, h2 = null, res = head;
        int i;
        for (i = 0; i < k - 1 && res.next != null; i++) {
            res = res.next;
        }
        if(i < k - 1){
           return head;
        }
        h1 = head;
        p1 = head;
        p2 = p1.next;
        if (p2 == null) return head;
        p3 = p2.next;
//        if(p3 == null && k >= 2){
//            p2.next = p1;
//            p1.next = null;
//            return head;
//        }else if(p3 == null){
//            return head;
//        }
        do {
            ListNode test = p1;
            int j;
            for (j = 0; j < k - 1 && test.next != null ; j++) {
                test = test.next;
            }
            if(j < k - 1){
                h1.next = p1;
                break;
            }else {
                h1.next = test;
                h1 = p1;
            }
            for (i = 0; i < k - 1 && p3 != null; i++) {
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
            }
            if(i == k - 1 && p3 == null){
                h1.next = p2;
                break;
            }else if(i != k - 1){
                p2.next = p1;
                h1.next = null;
                break;
            }
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        } while (true);
        return res;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < 10; i++) {
            p.next = new ListNode(i + 1);
            p = p.next;
        }
        System.out.println(head);
        System.out.println(
                LeetCode25.reverseKGroup1(head, 6)
        );
    }
}
