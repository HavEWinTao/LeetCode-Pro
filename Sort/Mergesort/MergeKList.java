import java.util.Objects;

/**
 * @author fantastic
 */
public class MergeKList {

    private ListNode[] listNodes;

    public ListNode mergeKLists(ListNode[] _lists) {
        if (Objects.isNull(_lists) || _lists.length == 0) {
            return null;
        }
        listNodes = _lists;
        return mergeSort(0, _lists.length - 1);
    }

    private ListNode mergeSort(int start, int end) {
        if (end - start == 1) {
            return merge(listNodes[start], listNodes[end]);
        }
        if (start == end) {
            return listNodes[start];
        }
        int mid = (start + end) / 2;
        ListNode left = mergeSort(start, mid);
        ListNode right = mergeSort(mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode ret = new ListNode();
        ListNode head = ret;
        while (Objects.nonNull(left) && Objects.nonNull(right)) {
            if (left.val < right.val) {
                head.next = new ListNode(left.val);
                left = left.next;
            } else {
                head.next = new ListNode(right.val);
                right = right.next;
            }
            head = head.next;
        }
        while (Objects.nonNull(left)) {
            head.next = new ListNode(left.val);
            left = left.next;
            head = head.next;
        }
        while (Objects.nonNull(right)) {
            head.next = new ListNode(right.val);
            right = right.next;
            head = head.next;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        MergeKList solution = new MergeKList();
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        l11.next = l12;
        l12.next = new ListNode(5);

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        l21.next = l22;
        l22.next = new ListNode(4);

        ListNode l31 = new ListNode(2);
        l31.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l11, l21, l31};
        System.out.println(solution.mergeKLists(lists));
    }
}
