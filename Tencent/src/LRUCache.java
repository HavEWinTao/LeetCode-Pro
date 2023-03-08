import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Node> map;

    private final int capacity;

    private final Node head;

    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node ret = map.get(key);
        removeNode(ret);
        addNode(ret);
        return ret.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
            return;
        }
        Node insertNode = new Node(key, value);
        map.put(key, insertNode);
        if (map.size() <= capacity) {
            addNode(insertNode);
        } else {
            addNode(insertNode);
            map.remove(tail.key);
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        if (head.next != null) {
            head.next.prev = node;
        }
        head.next = node;
        if (tail == head) {
            tail = head.next;
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        if (node.next != null) {//不是最后一个结点
            node.next.prev = node.prev;
        } else {//是最后一个结点
            tail = node.prev;
        }
    }

    static class Node {
        public Node prev;

        public Node next;

        public int val;

        public final int key;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
}