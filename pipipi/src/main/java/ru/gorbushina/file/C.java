package ru.gorbushina.file;
import ru.gorbushina.file.ToString;

@ToString(ToString.Value.NO)
public class C extends Entity {
    String field1 = "test";
    @ToString(ToString.Value.YES)
    int field2 = 100;
}
