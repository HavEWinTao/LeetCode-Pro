import java.util.HashMap;
import java.util.Map;

/**
 * @author fantastic
 */
public class FrequencySort {
    public String frequencySort(String s) {
        Map<Integer, Integer> char2cnt = new HashMap<>();
        for (int c : s.toCharArray()) {
            int cnt = char2cnt.getOrDefault(c, 0);
            char2cnt.put(c, cnt + 1);
        }
        int[][] arr = new int[char2cnt.size()][2];
        int index = 0;
        for (int c : char2cnt.keySet()) {
            arr[index++] = new int[]{c, char2cnt.get(c)};
        }
        Heap<int[]> heap = new Heap<>(arr, ((o1, o2) -> o1[1] - o2[1]));
        StringBuilder sb = new StringBuilder();
        while (heap.size() != 0) {
            int[] top = heap.pop();
            for (int i = 0; i < top[1]; i++) {
                sb.append((char) top[0]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FrequencySort solution = new FrequencySort();
        String s = "tree";
        System.out.println(solution.frequencySort(s));
    }
}
