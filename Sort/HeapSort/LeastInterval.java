import java.util.*;

/**
 * @author fantastic
 */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> task2cnt = new HashMap<>();
        for (char c : tasks) {
            int cnt = task2cnt.getOrDefault(c, 0);
            task2cnt.put(c, cnt + 1);
        }
        int[][] arr = new int[task2cnt.size()][];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : task2cnt.entrySet()) {
            arr[index++] = new int[]{entry.getKey(), entry.getValue()};
        }
        Heap<int[]> heap = new Heap<>(arr, (Comparator.comparingInt(o -> o[1])));
        int ans = 0;
        while (!heap.isEmpty()) {
            List<int[]> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (heap.isEmpty() && temp.isEmpty()) {
                    break;
                }
                if (!heap.isEmpty()) {
                    int[] top = heap.pop();
                    if (top[1] > 1) {
                        temp.add(new int[]{top[0], top[1] - 1});
                    }
                }
                ans++;
            }
            for (int[] item : temp) {
                heap.add(item);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeastInterval solution = new LeastInterval();
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(solution.leastInterval(tasks, n));
    }
}
