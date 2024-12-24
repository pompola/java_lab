import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Invoke {
}

// Класс для демонстрации @Invoke
class AnotherClass {
    @Invoke
    public void myMethod() {
        System.out.println("Метод, помеченный аннотацией @Invoke, был вызван.");
    }
}