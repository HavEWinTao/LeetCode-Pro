import java.util.Stack;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverse = reverseList(slow);
        while (reverse != null && head != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode list) {
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
        IsPalindrome solution = new IsPalindrome();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(1);
        System.out.println(solution.isPalindrome(list));
    }
}
