/**
 * @author fantastic
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head = this;
        sb.append('[');
        boolean flag = false;
        while (head != null) {
            if (flag) {
                sb.append(',');
            }
            flag = true;
            sb.append(head.val);
            head = head.next;
        }
        sb.append(']');
        return sb.toString();
    }
}