import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    String[] value() default {};
}

// Классы для демонстрации @Cache
@Cache
class TestClassCache {
}

@Cache(value = {"test1","test2"})
class TestClassCacheValue {
}