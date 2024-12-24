import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    Class<?>[] value();
}

// Класс для демонстрации @Validate
@Validate(value = {Integer.class, Double.class})
class TestClassValidate{
}
