import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер задачи (номера как в файле, только без точек):");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        switch (taskNumber) {
            case 1:
                Drob5 d1 = new Drob5(1, -5);
                System.out.println(d1.getRealValue());
                System.out.println("Из кэша:");
                System.out.println(d1.getRealValue());

                Drob5 d2 = new Drob5(3, 4);
                System.out.println(d2.getRealValue());

                System.out.println(d1.equals(new Drob5(1,2)));
                System.out.println(d1.equals(new Drob5(2,1)));

                System.out.println(d1 + " + " + d2 + " = " + d1.sum(d2));

                break;

            case 2:
                System.out.print("Введите имя котика: ");
                String catName = scanner.nextLine();

                try {
                    Cat cat = new Cat(catName);
                    System.out.println("Создан котик: " + cat);

                    MeowManager.makeCatMeow(cat);

                    System.out.println("Котик " + cat.getName() + " мяукнул " + cat.getMeowCount() + " раз.");

                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка: " + e.getMessage());
                }
                scanner.close();

                break;

            case 3:
                ListData list1 = new ListData();
                list1.add(1);
                list1.add(2);
                list1.add(3);
                list1.add(4);
                list1.add(5);
                list1.add(3); // дубликат, чтобы показать что они игнорируются


                ListData list2 = new ListData();
                list2.add(3);
                list2.add(5);
                list2.add(6);
                list2.add(7);


                try {
                    ListData result = list1.subtract(list2);
                    System.out.println("список 1: " + list1);
                    System.out.println("список 2: " + list2);
                    System.out.println("результат: " + result);

                    //Пример с null-значением - проверка обработки исключений
                    ListData result2 = list1.subtract(null);
                    System.out.println("результат 2: " + result2);

                } catch (IllegalArgumentException e) {
                    System.err.println("ошибка: " + e.getMessage());
                }

                break;

            case 4:
                Map<Integer, List<Student>> schoolStudents = new HashMap<>();
                String filePath = "school.txt";

                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    int n = Integer.parseInt(reader.readLine());
                    if (n <= 0) {
                        System.out.println("Ошибка: количество учеников должно быть больше 0.");
                        return;
                    }

                    for (int i = 0; i < n; i++) {
                        String line = reader.readLine();
                        if (line == null || line.trim().isEmpty()) {
                            System.out.println("Ошибка: строка " + (i + 2) + " пустая или некорректная.");
                            return;
                        }
                        String[] parts = line.split("\s+");
                        if (parts.length != 4) {
                            System.out.println("Ошибка: некорректный формат строки " + (i + 2));
                            return;
                        }

                        try {
                            Student student = new Student(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                            schoolStudents.computeIfAbsent(student.school, k -> new ArrayList<>()).add(student);
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка: некорректные данные в строке " + (i + 2));
                            return;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при чтении файла: " + e.getMessage());
                    return;
                }

                List<Student> topStudents = Student.findTopStudents(schoolStudents, 50);

                if (topStudents == null) {
                    if(schoolStudents.get(50) == null || schoolStudents.get(50).size() < 5){
                        System.out.println("Ошибка:  в школе №50 меньше 5 учеников или данные отсутствуют.");
                    } else {
                        int topScore = schoolStudents.get(50).get(0).score;
                        int countTopScore = 0;
                        for (Student student : schoolStudents.get(50)) {
                            if (student.score == topScore) countTopScore++;
                            else break;
                        }
                        System.out.println(countTopScore);
                    }
                } else {
                    for (Student student : topStudents) {
                        System.out.println(student);
                    }
                }

                break;

            case 5:
                String filename = "input.txt";
                if (args.length > 0) {
                    filename = args[0];
                }

                Bukva bukva = new Bukva();
                String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        for (char c : line.toCharArray()) {
                            if (Character.isLetter(c)) {
                                bukva.addLetter(c);
                            }
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка при чтении файла: " + e.getMessage());
                    return;
                }

                if (bukva.getLetters().isEmpty()) {
                    System.err.println("Файл пуст или не содержит букв русского алфавита.");
                    return;
                }

                Set<Character> missingLetters = bukva.getMissingLetters(alphabet);
                TreeSet<Character> sortedMissingLetters = new TreeSet<>(missingLetters);

                System.out.println("Список отсутствующих букв: " + sortedMissingLetters);
                System.out.println("Количество отсутствующих букв: " + sortedMissingLetters.size());
                System.out.println(bukva);

                break;

            case 6:
                Integer[] arr1 = {1, 2, 3, 4, 5};
                Integer[] arr2 = {1, 2, 2, null,  4, 5};
                Integer[] arr3 = {1, 2, 8, 9, 1};
                Integer[] arr4 = {};
                Integer[] arr5 = {18};
                Integer[] arr6 = {1,2, null, 4, 5};

                Ochered ochered1 = new Ochered(arr1);
                Ochered ochered2 = new Ochered(arr2);
                Ochered ochered3 = new Ochered(arr3);
                Ochered ochered4 = new Ochered(arr4);
                Ochered ochered5 = new Ochered(arr5);
                Ochered ochered6 = new Ochered(arr6);


                System.out.println("Очередь 1: " + ochered1 + ", Содержит одинаковые соседние элементы: " + ochered1.hasConsecutiveEqualElements());
                System.out.println("Очередь 2: " + ochered2 + ", Содержит одинаковые соседние элементы: " + ochered2.hasConsecutiveEqualElements());
                System.out.println("Очередь 3: " + ochered3 + ", Содержит одинаковые соседние элементы: " + ochered3.hasConsecutiveEqualElements());
                System.out.println("Очередь 4: " + ochered4 + ", Содержит одинаковые соседние элементы: " + ochered4.hasConsecutiveEqualElements());
                System.out.println("Очередь 5: " + ochered5 + ", Содержит одинаковые соседние элементы: " + ochered5.hasConsecutiveEqualElements());
                System.out.println("Очередь 6: " + ochered6 + ", Содержит одинаковые соседние элементы: " + ochered6.hasConsecutiveEqualElements());

                break;

            case 71:
                List<Point> points = Arrays.asList(
                        new Point(1, 2),
                        new Point(3, 4),
                        new Point(1, 2),
                        new Point(-5, -6),
                        new Point(3,4),
                        new Point(7,8)

                );

                if (points == null || points.isEmpty()) {
                    System.out.println("Входной список точек пуст или null.");
                    return;
                }


                Polyline polyline = points.stream()
                        .distinct() // Убираем дубликаты
                        .sorted(Comparator.comparingDouble(Point::getX)) // Сортируем по X
                        .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Делаем Y положительными
                        .collect(Collectors.collectingAndThen(
                                Collectors.toList(),
                                Polyline::new
                        ));

                System.out.println(polyline);

                break;

            case 72:
                String fileName = "people.txt";

                try {
                    Group group = Group.processFile(fileName);
                    System.out.println(group);
                } catch (IOException e) {
                    System.err.println("Ошибка при обработке файла: " + e.getMessage());
                }

                break;

            default:
                System.out.println("Неверный номер задачи");
        }
    }
}
