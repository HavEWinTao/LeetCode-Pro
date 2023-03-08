import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fantastic
 * 堆
 */
public class Heap<T> {
    private Object[] arr;

    private int size = 0;

    private int capacity = 10;

    private final Comparator<? super T> comparator;

    Heap(T[] arr, Comparator<? super T> comparator) {
        size = arr.length;
        capacity = size;
        this.arr = arr.clone();
        this.comparator = comparator;
        heapify();
    }

    Heap(Comparator<? super T> comparator) {
        size = 0;
        this.arr = new Object[capacity];
        this.comparator = comparator;
    }

    Heap(Heap<T> heap) {
        size = heap.size;
        capacity = heap.capacity;
        this.arr = heap.arr.clone();
        this.comparator = heap.comparator;
    }

    void heapify() {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 对某一个节点进行上浮操作
     * 浮动到上面
     */
    private void up(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (comparator.compare((T) arr[index], (T) arr[parent]) > 0) {
                swap(index, parent);
            }
            index = parent;
        }
    }

    /**
     * 对某一个节点进行下沉操作
     * 下沉到下面
     */
    private void down(int index) {
        while (index < size) {
            int left = index * 2 + 1 < size ? index * 2 + 1 : -1;
            int right = (index + 1) * 2 < size ? (index + 1) * 2 : -1;
            int temp = -1;
            if (right == -1) {
                //已经到了叶子节点
                if (left == -1) {
                    break;
                } else {
                    temp = left;
                }
            } else {
                if (comparator.compare((T) arr[left], (T) arr[right]) > 0) {
                    temp = left;
                } else {
                    temp = right;
                }
            }
            if (comparator.compare((T) arr[temp], (T) arr[index]) > 0) {
                swap(temp, index);
            }
            index = temp;
        }
    }

    public T pop() {
        if (size == 0) {
            throw new Error("heap is empty error");
        }
        T ret = (T) arr[0];
        swap(0, size - 1);
        size--;
        down(0);
        return ret;
    }

    public void add(T element) {
        size++;
        if (size > capacity) {
            capacity = capacity * 2;
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[size - 1] = element;
        up(size - 1);
    }

    public T top() {
        if (size == 0) {
            return null;
        }
        return (T) arr[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swap(int i, int j) {
        if (i < 0 || i >= size) {
            throw new Error("index out of bounds error");
        }
        if (j < 0 || j >= size) {
            throw new Error("index out of bounds error");
        }
        T temp = (T) arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
