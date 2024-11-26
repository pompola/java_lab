interface Comparable<T> {
    int compare(T other);
}

class IntegerComparable implements Comparable<Integer> {
    private Integer value;

    public IntegerComparable(Integer value) {
        this.value = value;
    }

    @Override
    public int compare(Integer other) {
        if (this.value == null) {
            return other.compareTo(0);
        }
        return this.value.compareTo(other);
    }
}

class StringComparable implements Comparable<String> {
    private String value;

    public StringComparable(String value) {
        this.value = value;
    }

    @Override
    public int compare(String other) {
        return this.value.compareTo(other);
    }
}