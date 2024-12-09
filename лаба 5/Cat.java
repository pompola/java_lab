interface Meowing {
    void meow();
}

class Cat implements Meowing {
    private final String name;
    private int meowCount = 0;

// Главный конструктор
    public Cat(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя котика не может быть пустым.");
        }
        this.name = name;
    }
// Геттер для имени
    public String getName() {
        return name;
    }
// Метод мяуканья
    @Override
    public void meow() {
        System.out.println(this.name + ": мяу!");
        meowCount++;
    }

// Метод получения количества мяуканий
    public int getMeowCount() {
        return meowCount;
    }

    @Override
    public String toString() {
        return "Котик: " + this.name;
    }
}

// Класс для работы с мяуканьем
class MeowManager {
    public static void makeCatMeow(Cat cat) {
        if (cat == null) {
            System.out.println("Кот не передан.");
            return;
        }
        cat.meow(); // один вызов
        cat.meow(); // Еще один вызов
    }
}
