import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private final int capacity;

    private int minFreq;

    private final Map<Integer, Node> key2node;

    private final Map<Integer, DeLinkedList> freq2List;

    public LFUCache(int capacity) {
        minFreq = 1;
        this.capacity = capacity;
        key2node = new HashMap<>();
        freq2List = new HashMap<>();
    }

    public int get(int key) {
        if (!key2node.containsKey(key)) {
            return -1;
        }
        Node node = key2node.get(key);
        DeLinkedList list1 = freq2List.get(node.freq);
        list1.removeNode(node);
        if (list1.size == 0 && minFreq == node.freq) {
            minFreq++;
        }
        node.freq++;
        DeLinkedList list2 = freq2List.getOrDefault(node.freq, new DeLinkedList());
        freq2List.put(node.freq, list2);
        list2.addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        //更新
        if (key2node.containsKey(key)) {
            update(key, value);
            return;
        }
        Node node = new Node(key, value, 1);
        //直接插入
        if (key2node.size() < capacity) {
            key2node.put(key, node);
            DeLinkedList list = freq2List.getOrDefault(1, new DeLinkedList());
            freq2List.put(1, list);
            list.addNode(node);
            minFreq = 1;
        } else {//替换
            DeLinkedList list = freq2List.get(minFreq);
            Node last = list.getLast();
            key2node.remove(last.key);
            list.removeNode(last);
            put(key, value);
        }
    }

    private void update(int key, int val) {
        Node node = key2node.get(key);
        DeLinkedList list1 = freq2List.get(node.freq);
        list1.removeNode(node);
        if (list1.size == 0 && minFreq == node.freq) {
            minFreq++;
        }
        node.freq++;
        minFreq = Math.min(minFreq, node.freq);
        DeLinkedList list2 = freq2List.getOrDefault(node.freq, new DeLinkedList());
        freq2List.put(node.freq, list2);
        list2.addNode(node);
        node.val = val;
    }

    public static void main(String[] args) {
        int temp;
        //genTestCase();
        LFUCache lfu = new LFUCache(10);
        lfu.put(10, 13);
        lfu.put(3, 17);
        lfu.put(6, 11);
        lfu.put(10, 5);
        lfu.put(9, 10);
        temp = lfu.get(13);
        lfu.put(2, 19);
        temp = lfu.get(2);
        temp = lfu.get(3);
        lfu.put(5, 25);
        temp = lfu.get(8);
        lfu.put(9, 22);
        lfu.put(5, 5);
        lfu.put(1, 30);
        temp = lfu.get(11);
        lfu.put(9, 12);
        temp = lfu.get(7);
        temp = lfu.get(5);
        temp = lfu.get(8);
        temp = lfu.get(9);
        lfu.put(4, 30);
        lfu.put(9, 3);
        temp = lfu.get(9);
        temp = lfu.get(10);
        temp = lfu.get(10);
        lfu.put(6, 14);
        lfu.put(3, 1);
        temp = lfu.get(3);
        lfu.put(10, 11);
        temp = lfu.get(8);
        lfu.put(2, 14);
        temp = lfu.get(1);
        temp = lfu.get(5);
        temp = lfu.get(4);
        lfu.put(11, 4);
        lfu.put(12, 24);
        lfu.put(5, 18);
        temp = lfu.get(13);
        lfu.put(7, 23);
        temp = lfu.get(8);
        temp = lfu.get(12);
        lfu.put(3, 27);
        lfu.put(2, 12);
        temp = lfu.get(5);
        lfu.put(2, 9);
        lfu.put(13, 4);
        lfu.put(8, 18);
        lfu.put(1, 7);
        temp = lfu.get(6);
        lfu.put(9, 29);
        lfu.put(8, 21);
        temp = lfu.get(5);
        lfu.put(6, 30);
        lfu.put(1, 12);
        temp = lfu.get(10);
        lfu.put(4, 15);
        lfu.put(7, 22);
        lfu.put(11, 26);
        lfu.put(8, 17);
        lfu.put(9, 29);
        temp = lfu.get(5);
        lfu.put(3, 4);
        lfu.put(11, 30);
        temp = lfu.get(12);
        lfu.put(4, 29);
        temp = lfu.get(3);
        temp = lfu.get(9);
        temp = lfu.get(6);
        lfu.put(3, 4);
        temp = lfu.get(1);
        temp = lfu.get(10);
        lfu.put(3, 29);
        lfu.put(10, 28);
        lfu.put(1, 20);
        lfu.put(11, 13);
        temp = lfu.get(3);
        lfu.put(3, 12);
        lfu.put(3, 8);
        lfu.put(10, 9);
        lfu.put(3, 26);
        temp = lfu.get(8);
        temp = lfu.get(7);
        temp = lfu.get(5);
        lfu.put(13, 17);
        lfu.put(2, 27);
        lfu.put(11, 15);
        temp = lfu.get(12);
        lfu.put(9, 19);
        lfu.put(2, 15);
        lfu.put(3, 16);
        temp = lfu.get(1);
        lfu.put(12, 17);
        lfu.put(9, 1);
        lfu.put(6, 19);
        temp = lfu.get(4);
        temp = lfu.get(5);
        temp = lfu.get(5);
        lfu.put(8, 1);
        lfu.put(11, 7);
        lfu.put(5, 2);
        lfu.put(9, 28);
        temp = lfu.get(1);
        lfu.put(2, 2);
        lfu.put(7, 4);
        lfu.put(4, 22);
        lfu.put(7, 24);
        lfu.put(9, 26);
        lfu.put(13, 28);
        lfu.put(11, 26);
    }

    private static void genTestCase() {
        String[] strs = new String[]{"LFUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
        int[][] nums = new int[][]{{10}, {10, 13}, {3, 17}, {6, 11}, {10, 5}, {9, 10}, {13}, {2, 19}, {2}, {3}, {5, 25}, {8}, {9, 22}, {5, 5}, {1, 30}, {11}, {9, 12}, {7}, {5}, {8}, {9}, {4, 30}, {9, 3}, {9}, {10}, {10}, {6, 14}, {3, 1}, {3}, {10, 11}, {8}, {2, 14}, {1}, {5}, {4}, {11, 4}, {12, 24}, {5, 18}, {13}, {7, 23}, {8}, {12}, {3, 27}, {2, 12}, {5}, {2, 9}, {13, 4}, {8, 18}, {1, 7}, {6}, {9, 29}, {8, 21}, {5}, {6, 30}, {1, 12}, {10}, {4, 15}, {7, 22}, {11, 26}, {8, 17}, {9, 29}, {5}, {3, 4}, {11, 30}, {12}, {4, 29}, {3}, {9}, {6}, {3, 4}, {1}, {10}, {3, 29}, {10, 28}, {1, 20}, {11, 13}, {3}, {3, 12}, {3, 8}, {10, 9}, {3, 26}, {8}, {7}, {5}, {13, 17}, {2, 27}, {11, 15}, {12}, {9, 19}, {2, 15}, {3, 16}, {1}, {12, 17}, {9, 1}, {6, 19}, {4}, {5}, {5}, {8, 1}, {11, 7}, {5, 2}, {9, 28}, {1}, {2, 2}, {7, 4}, {4, 22}, {7, 24}, {9, 26}, {13, 28}, {11, 26}};
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            if (strs[i].equals("LFUCache")) {
                System.out.println("LFUCache lfu = new LFUCache(" + nums[i][0] + ");");
            }
            if (strs[i].equals("put")) {
                System.out.println("lfu.put(" + nums[i][0] + ", " + nums[i][1] + ");");
            }
            if (strs[i].equals("get")) {
                System.out.println("temp = lfu.get(" + nums[i][0] + ");");

            }
        }
    }
}

class Node {
    int key;
    int val;
    int freq;

    Node prev;
    Node next;

    Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

class DeLinkedList {
    Node head;
    Node tail;

    int size;

    DeLinkedList() {
        head = new Node(-1, -1, 0);
        tail = head;
        size = 0;
    }

    public void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        if (head.next != null) {
            head.next.prev = node;
        }
        head.next = node;
        if (tail == head) {
            tail = head.next;
        }
        size++;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        if (node.next != null) {//不是最后一个结点
            node.next.prev = node.prev;
        } else {//是最后一个结点
            tail = node.prev;
        }
        size--;
    }

    public Node getLast() {
        return tail;
    }
}
