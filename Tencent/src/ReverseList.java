public class ReverseList {
    public ListNode reverseList(ListNode list) {
        ListNode head = new ListNode();
        while (list != null) {
            ListNode node = list;
            list = list.next;
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ReverseList solution = new ReverseList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode temp = head.next.next;
        temp.next = new ListNode(4);
        temp.next.next = new ListNode(5);
        ListNode listNode = solution.reverseList(head);
    }
}