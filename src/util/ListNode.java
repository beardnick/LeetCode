package util;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode p = this;
        while (p.next != null && p.next != this){
            p = p.next;
            sb.append("->" + p.val);
        }
        return sb.toString();
    }
}
