package ru.gorbushina.file;
import ru.gorbushina.file.ToString;

public class D extends Entity {
    String s = "hello";
    @ToString(ToString.Value.NO)
    int x = 42;
}
