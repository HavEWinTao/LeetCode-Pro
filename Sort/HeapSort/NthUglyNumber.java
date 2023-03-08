import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fantastic
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        Heap<Long> heap = new Heap<>(Comparator.comparingLong(o -> -o));
        set.add(1L);
        heap.add(1L);
        long ans = 1;
        int[] factor = new int[]{2, 3, 5};
        for (int i = 1; i <= n; i++) {
            ans = heap.pop();
            for (int j = 0; j < 3; j++) {
                long num = ans * factor[j];
                if (!set.contains(num)) {
                    set.add(num);
                    heap.add(num);
                }
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        NthUglyNumber solution = new NthUglyNumber();
        System.out.println(solution.nthUglyNumber(1407));
    }
}
