package ru.gorbushina.file;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    enum Value {YES, NO}

    Value value() default Value.YES;
}

