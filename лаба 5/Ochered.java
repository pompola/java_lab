import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Ochered {
    private Queue<Integer> queue;

    public Ochered() {
        this.queue = new LinkedList<>();
    }

    public Ochered(Integer[] arr) {
        this.queue = new LinkedList<>(Arrays.asList(arr != null ? arr : new Integer[0]));
    }

    public boolean hasConsecutiveEqualElements() {
        if (queue.size() < 2) {
            return false;
        }

        Integer[] arr = queue.toArray(new Integer[0]);
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            Integer current = arr[i];
            Integer next = arr[(i + 1) % n];

            // Проверяем на null перед сравнением
            if (current == null || next == null) {
                continue; // Пропускаем, если один из элементов null
            }
            if (current.equals(next)) {
                return true;
            }
        }
        return false;
    }

    public void enqueue(Integer item) {
        queue.offer(item);
    }

    public Integer dequeue() {
        return queue.poll();
    }

    @Override
    public String toString() {
        return "" + queue;
    }
}