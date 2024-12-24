package ru.gorbushina.file;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Entity {
    @Override
    public String toString() {
        Class<?> clazz = this.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getSimpleName()).append("{");

        // Получаем все поля, включая унаследованные от родительских классов
        while (clazz != null) {
            final boolean classToStringNo =  clazz.isAnnotationPresent(ToString.class) &&
                    clazz.getAnnotation(ToString.class).value() == ToString.Value.NO;


            Class<?> finalClazz = clazz; // Создаем final переменную для использования в лямбде

            String fieldsString = Arrays.stream(finalClazz.getDeclaredFields())
                    .filter(field -> !field.getName().equals("this$0")) // Игнорируем ссылку на внешний класс для внутренних классов
                    .filter(field -> {
                        if (classToStringNo) { // Если весь класс помечен как @ToString(NO)
                            return field.isAnnotationPresent(ToString.class) && field.getAnnotation(ToString.class).value() == ToString.Value.YES;
                        } else { // Если нет, то пропускаем поля с @ToString(NO)
                            return !field.isAnnotationPresent(ToString.class) || field.getAnnotation(ToString.class).value() != ToString.Value.NO;
                        }
                    })
                    .map(field -> {
                        field.setAccessible(true); // Делаем поля доступными, чтобы получить их значение
                        try {
                            return field.getName() + "=" + field.get(this);
                        } catch (IllegalAccessException e) {
                            return field.getName() + "=ERROR"; // Обработка ошибки доступа
                        }
                    })
                    .collect(Collectors.joining(", "));


            if (!fieldsString.isEmpty()) {
                sb.append(fieldsString).append(", ");
            }

            clazz = clazz.getSuperclass();
        }

        if (sb.toString().endsWith(", ")) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("}");
        return sb.toString();
    }
}