class Box<T> {
    private T item;

    public Box() {
        this.item = null;
    }

    public boolean isEmpty() {
        return item == null;
    }

    public void put(T item) {
        if (!isEmpty()) {
            throw new IllegalStateException("Коробка не пуста. Невозможно поместить другой элемент.");
        }
        this.item = item;
    }

    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException("Коробка пуста. Не удается получить товар.");
        }
        T temp = item;
        item = null;
        return temp;
    }

    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Коробка[" + item + ']';
    }
}