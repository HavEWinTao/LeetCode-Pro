import java.util.Objects;

/**
 * @author fantastic
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head, null);
    }

    private ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        //找中点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = mergeSort(head, mid);
        ListNode list2 = mergeSort(mid, tail);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode head = ret;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        while (Objects.nonNull(l1)) {
            head.next = new ListNode(l1.val);
            l1 = l1.next;
            head = head.next;
        }
        while (Objects.nonNull(l2)) {
            head.next = new ListNode(l2.val);
            l2 = l2.next;
            head = head.next;
        }
        return ret.next;
    }
}