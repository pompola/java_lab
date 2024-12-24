import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    String first();
    int second();
}

// Класс для демонстрации @Two
@Two(first = "hello", second = 10)
class TestClassTwo {
}
