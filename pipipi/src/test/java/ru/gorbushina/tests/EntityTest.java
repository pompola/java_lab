package ru.gorbushina.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.gorbushina.file.D;
import ru.gorbushina.file.C;
import ru.gorbushina.file.Entity;


public class EntityTest {

    // Тест для класса D. Проверяет, что вывод метода toString корректен, учитывая
    // аннотацию @ToString(NO) для поля x. Ожидается, что поле x не будет включено в вывод.
    @Test
    void testClassD() {
        D d = new D();
        assertEquals("D{s=hello}", d.toString());
    }

    // Тест для класса C. Проверяет, что вывод метода toString корректен, учитывая аннотацию
    // @ToString(NO) для всего класса и аннотацию @ToString(YES) для поля field2.
    // Ожидается, что будет включено только поле field2.
    @Test
    void testClassC() {
        C c = new C();
        assertEquals("C{field2=100}", c.toString());
    }
    // Тест для класса Entity. Проверяет, что вывод метода toString корректен, если поля не имеют аннотации @ToString.
    @Test
    void testClassEntity(){
        Entity entity = new Entity();
        assertEquals("Entity{}", entity.toString());
    }
}
