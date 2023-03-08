/**
 * @author fantastic
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Heap<ListNode> heap = new Heap<>(lists, (o1, o2) -> {
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return o2.val - o1.val;
        });
        ListNode ans = new ListNode();
        ListNode tail = ans;
        while (heap.top() != null) {
            tail.next = new ListNode(heap.top().val);
            tail = tail.next;
            ListNode temp = heap.top();
            temp = temp.next;
            heap.pop();
            heap.add(temp);
        }
        return ans.next;
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
