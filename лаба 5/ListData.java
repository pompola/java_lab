import java.util.ArrayList;
import java.util.List;

class ListData {
    private List<Integer> data;

    public ListData() {
        this.data = new ArrayList<>();
    }

    public ListData(List<Integer> data) {
        this.data = new ArrayList<>(data); // Defensive copy
    }

    public void add(int element) {
        if (!this.data.contains(element)) {
            this.data.add(element);
        }
    }

    public List<Integer> getData() {
        return new ArrayList<>(data);
    }

    public ListData subtract(ListData other) {
        if (other == null) {
            throw new IllegalArgumentException("список не может быть пустым");
        }
        ListData result = new ListData();
        for (int element : this.data) {
            if (!other.data.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }


    @Override
    public String toString() {
        return "{" + data + '}';
    }
}