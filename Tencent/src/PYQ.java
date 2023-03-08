import java.util.*;

public class PYQ {

    static Scanner in = new Scanner(System.in);

    private static void func() {
        int m = in.nextInt();
        Map<Integer, Set<Integer>> relation = new HashMap<>();
        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            Set<Integer> temp1 = relation.getOrDefault(a, new HashSet<>());
            temp1.add(b);
            relation.put(a, temp1);
            Set<Integer> temp2 = relation.getOrDefault(b, new HashSet<>());
            temp2.add(a);
            relation.put(b, temp2);
        }
        Set<Integer> visit = new HashSet<>();
        int ans = 1;
        for (int key : relation.keySet()) {
            if (!visit.contains(key)) {
                ans = Math.max(ans, BFS(key, visit, relation));
            }
        }
        System.out.println(ans);
    }

    private static int BFS(int key, Set<Integer> visit, Map<Integer, Set<Integer>> relations) {
        if (visit.contains(key)) {
            return 0;
        }
        int ret = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(key);
        visit.add(key);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            ret++;
            Set<Integer> relation = relations.get(temp);
            for (int pep : relation) {
                if (!visit.contains(pep)) {
                    queue.add(pep);
                    visit.add(pep);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int T = in.nextInt();
        while (T-- > 0) {
            func();
        }
    }
}
