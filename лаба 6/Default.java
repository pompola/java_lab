import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Default {
    Class<?> value();
}

// Класс для демонстрации @Default
@Default(value = String.class)
class TestClassDefault {
    @Default(value = Integer.class)
    private int number;
}
