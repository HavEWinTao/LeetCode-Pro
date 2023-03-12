public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != null && l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode head1 = l1 == null ? headB : headA;
        ListNode head2 = l1 == null ? headA : headB;
        ListNode tail = l1 == null ? l2 : l1;
        while (tail != null && head1 != null) {
            tail = tail.next;
            head1 = head1.next;
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}
