package normal;

import util.ListNode;

public class LeetCode2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        if(p1 == null){
            return p2;
        }
        if(p2 == null){
            return p1;
        }
        ListNode result = new ListNode(0), p3 = result;
        int c0 = 0 , c1 = 0, s = 0;
        while (p1 != null || p2 != null) {
            if(p1 != null && p2 != null) {
                c1 = (p1.val + p2.val + c0) / 10;
                s = (p1.val + p2.val + c0) % 10;
                p1 = p1.next;
                p2 = p2.next;
            }else{
                ListNode node;
                if(p1 != null){
                    node = p1;
                    p1 = p1.next;
                }else {
                    node = p2;
                    p2 = p2.next;
                }
                c1 = (node.val + c0) / 10;
                s = (node.val + c0) % 10;
            }
            c0 = c1;
            p3.next = new ListNode(s);
            p3 = p3.next;
        }
        if(c0 != 0){
            p3.next = new ListNode(c0);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(6);
        System.out.println(head);
        System.out.println(head1);
        System.out.println(
                LeetCode2.addTwoNumbers(
                        head , head1
                )
        );
        System.out.println(
                LeetCode2.addTwoNumbers(
                        new ListNode(5) , new ListNode(5)
                )
        );
    }
}
