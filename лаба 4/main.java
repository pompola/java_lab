import java.util.Scanner;
import java.util.function.Function;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер задачи (номера как в файле, только без точек):");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        switch (taskNumber) {
            case 11:
                System.out.println("Выберите тип данных для коробки (Integer, String, Double):");
                String type = scanner.nextLine().trim().toLowerCase();

                Box<?> box = null; //объявление не нужно

                Box<Integer> intBox = null;
                Box<String> stringBox = null;
                Box<Double> doubleBox = null;

                if (type.equals("integer")) {
                    intBox = new Box<>();
                } else if (type.equals("string")) {
                    stringBox = new Box<>();
                } else if (type.equals("double")) {
                    doubleBox = new Box<>();
                } else {
                    System.out.println("Неверный тип данных.");
                    return;
                }


                while (true) {
                    System.out.println("\nВыберите действие:");
                    System.out.println("1. Положить объект в коробку");
                    System.out.println("2. Взять объект из коробки");
                    System.out.println("3. Проверить заполненность коробки");
                    System.out.println("4. Выйти");

                    int choice = 0;
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод. Пожалуйста, введите число.");
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            if (intBox != null) {
                                putInBox(intBox, scanner, Integer::parseInt);
                            } else if (stringBox != null) {
                                putInBox(stringBox, scanner, s -> s);
                            } else if (doubleBox != null) {
                                putInBox(doubleBox, scanner, Double::parseDouble);
                            }
                            break;
                        case 2:
                            if (intBox != null) {
                                getFromBox(intBox);
                            } else if (stringBox != null) {
                                getFromBox(stringBox);
                            } else if (doubleBox != null) {
                                getFromBox(doubleBox);
                            }
                            break;
                        case 3:
                            if (intBox != null) {
                                System.out.println("Коробка " + (intBox.isEmpty() ? "пуста" : "заполнена"));
                            } else if (stringBox != null) {
                                System.out.println("Коробка " + (stringBox.isEmpty() ? "пуста" : "заполнена"));
                            } else if (doubleBox != null) {
                                System.out.println("Коробка " + (doubleBox.isEmpty() ? "пуста" : "заполнена"));
                            }
                            break;
                        case 4:
                            System.out.println("Выход.");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Неверный выбор.");
                    }
                }
            case 13:
                int num1, num2;
                String str1, str2;

                // Ввод и проверка первого целого числа
                System.out.println("Введите первое целое число:");
                do {
                    try {
                        num1 = scanner.nextInt();
                        break; // Выходим из цикла, если ввод корректный
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод. Пожалуйста, введите целое число:");
                        scanner.next(); // Очищаем буфер ввода от некорректного значения
                    }
                } while (true);


                // Ввод и проверка второго целого числа
                System.out.println("Введите второе целое число:");
                do {
                    try {
                        num2 = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Некорректный ввод. Пожалуйста, введите целое число:");
                        scanner.next();
                    }
                } while (true);
                scanner.nextLine(); // Очищаем буфер после nextInt()


                IntegerComparable int1 = new IntegerComparable(num1);
                IntegerComparable int2 = new IntegerComparable(num2);
                System.out.println("Результат сравнения целых чисел: " + int1.compare(num2));


                // Ввод и проверка первой строки (проверка на пустую строку)
                System.out.println("Введите первую строку:");
                do {
                    str1 = scanner.nextLine();
                    if (str1.isEmpty()) {
                        System.out.println("Строка не может быть пустой. Пожалуйста, введите строку:");
                    } else {
                        break;
                    }
                } while (true);

                // Ввод и проверка второй строки (проверка на пустую строку)
                System.out.println("Введите вторую строку:");
                do {
                    str2 = scanner.nextLine();
                    if (str2.isEmpty()) {
                        System.out.println("Строка не может быть пустой. Пожалуйста, введите строку:");
                    } else {
                        break;
                    }
                } while (true);


                StringComparable string1 = new StringComparable(str1);
                StringComparable string2 = new StringComparable(str2);
                System.out.println("Результат сравнения строк: " + string1.compare(str2));

                scanner.close();
                break;

            case 2:
                List<Box<?>> boxes = new ArrayList<>();

                System.out.print("Сколько коробок вы хотите создать? ");
                int numBoxes = 0;
                try {
                    numBoxes = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Неверный ввод. Завершение работы.");
                    return;
                }

                for (int i = 0; i < numBoxes; i++) {
                    System.out.println("\nКоробка №" + (i + 1));
                    System.out.println("Выберите тип данных для коробки (Integer, String, Double):");
                    String boxType = scanner.nextLine().trim().toLowerCase();

                    Box<?> box1 = null;

                    if (boxType.equals("integer")) {
                        box1 = new Box<Integer>();
                    } else if (boxType.equals("string")) {
                        box1 = new Box<String>();
                    } else if (boxType.equals("double")) {
                        box1 = new Box<Double>();
                    } else {
                        System.out.println("Неверный тип данных. Коробка не создана.");
                        i--; // Decrement i to recreate the box
                        continue;
                    }
                    boxes.add(box1);
                }

                while (true) {
                    System.out.println("\nВыберите коробку (1-" + numBoxes + ") или 0 для выхода, или -1 для поиска максимального значения:");
                    int boxIndex = 0;
                    try {
                        boxIndex = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод. Пожалуйста, введите число.");
                        continue;
                    }

                    if (boxIndex == 0) {
                        System.out.println("Выход.");
                        break;
                    }

                    if (boxIndex == -1) {
                        try {
                            double maxVal = findMaxDoubleValue(boxes);
                            System.out.println("Максимальное значение: " + maxVal);
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            System.err.println("Ошибка: " + e.getMessage());
                        }
                        continue;
                    }


                    if (boxIndex < 1 || boxIndex > numBoxes) {
                        System.out.println("Неверный номер коробки.");
                        continue;
                    }

                    Box<?> selectedBox = boxes.get(boxIndex - 1);

                    System.out.println("\nВыберите действие для коробки №" + boxIndex + ":");
                    System.out.println("1. Положить объект в коробку");
                    System.out.println("2. Взять объект из коробки");
                    System.out.println("3. Проверить заполненность коробки");

                    int choice = 0;
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод. Пожалуйста, введите число.");
                        continue;
                    }

                    Box<Integer> intBox1 = null;
                    Box<String> stringBox1 = null;
                    Box<Double> doubleBox1 = null;

                    switch (choice) {
                        case 1:
                            if (intBox1 == null) {
                                putInBox(intBox1, scanner, Integer::parseInt);
                            } else if (stringBox1 == null) {
                                putInBox(stringBox1, scanner, s -> s);
                            } else if (doubleBox1 == null) {
                                putInBox(doubleBox1, scanner, Double::parseDouble);
                            }
                            break;
                        case 2:
                            getFromBox((Box<?>) selectedBox);
                            break;
                        case 3:
                            System.out.println("Коробка " + (((Box<?>) selectedBox).isEmpty() ? "пуста" : "заполнена"));
                            break;
                        default:
                            System.out.println("Неверный выбор.");
                    }
                }
                break;

            case 31:
                System.out.println("Выберите пример:");
                System.out.println("1. Список строк -> Список длин строк");
                System.out.println("2. Список целых чисел -> Список с абсолютными значениями");
                System.out.println("3. Список массивов целых чисел -> Список максимальных значений");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Введите строки, разделенные пробелами:");
                        String[] strings = scanner.nextLine().split(" ");
                        List<String> stringList = Arrays.asList(strings);
                        List<Integer> stringLengths = applyToEach(stringList, String::length);
                        System.out.println("Список длин строк: " + stringLengths);
                        break;
                    case 2:
                        System.out.println("Введите целые числа, разделенные пробелами:");
                        String[] numbersStr = scanner.nextLine().split(" ");
                        List<Integer> numbers = new ArrayList<>();
                        for (String numStr : numbersStr) {
                            try {
                                numbers.add(Integer.parseInt(numStr));
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный ввод. Введите целые числа, разделенные пробелами:");
                                numbers.clear(); //Очищаем список, если ввод некорректен
                                break; //Выходим из цикла обработки чисел и повторяем ввод
                            }
                        }
                        List<Integer> absoluteValues = applyToEach(numbers, Math::abs);
                        System.out.println("Список абсолютных значений: " + absoluteValues);
                        break;
                    case 3:
                        System.out.println("Введите массивы целых чисел. Каждый массив вводится на новой строке, элементы разделяются пробелами.  Введите 'end' для завершения ввода массивов.");
                        List<int[]> intArrays = new ArrayList<>();
                        String line;
                        while (!(line = scanner.nextLine()).equals("end")) {
                            String[] arrStr = line.split(" ");
                            int[] arr = new int[arrStr.length];
                            for (int i = 0; i < arrStr.length; i++) {
                                try {
                                    arr[i] = Integer.parseInt(arrStr[i]);
                                } catch (NumberFormatException e) {
                                    System.out.println("Некорректный ввод числа в массиве. Повторите ввод строки:");
                                    arr = new int[0]; //Очищаем массив, если ввод некорректен
                                    break;
                                }
                            }
                            intArrays.add(arr);
                        }
                        List<Integer> maxValues = applyToEach(intArrays, arr -> {
                            if(arr.length == 0) return 0; // Обработка пустого массива
                            int max = Integer.MIN_VALUE;
                            for (int num : arr) {
                                if (num > max) {
                                    max = num;
                                }
                            }
                            return max;
                        });
                        System.out.println("Список максимальных значений: " + maxValues);
                        break;
                    case 4:
                        System.out.println("Выход из программы.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 4.");
                }

                break;

            case 32:

                break;

            case 33:

                break;

            case 34:

                break;

            default:
                System.out.println("Неверный номер задачи");
        }
        scanner.close();
    }

    public static <T> void putInBox(Box<T> box, Scanner scanner, Function<String, T> parser) {
        System.out.print("Введите значение для коробки: ");
        String input = scanner.nextLine();
        try {
            T value = parser.apply(input);
            box.put(value);
            System.out.println("Значение добавлено в коробку.");
        } catch (Exception e) {
            System.out.println("Неверный формат ввода.");
        }
    }

    public static <T> void getFromBox(Box<T> box) {
        T value = box.get();
        if (value == null) {
            System.out.println("Коробка пуста.");
        } else {
            System.out.println("Из коробки взято: " + value);
        }
    }

    public static double findMaxDoubleValue(List<Box<?>> boxes) {
        double maxValue = Double.NEGATIVE_INFINITY;
        for (Box<?> box : boxes) {
            if (!box.isEmpty()) {
                Object item = box.getItem();
                if (item instanceof Number) {
                    maxValue = Math.max(maxValue, ((Number) item).doubleValue());
                } else if (item instanceof String) {
                    try {
                        maxValue = Math.max(maxValue, Double.parseDouble((String) item));
                    } catch (NumberFormatException e) {
                        // Игнорируем строки, которые нельзя преобразовать в double
                    }
                } else {
                    throw new IllegalArgumentException("Коробка содержит неподдерживаемый тип данных: " + item.getClass().getName());
                }
            }
        }
        if (maxValue == Double.NEGATIVE_INFINITY) {
            throw new IllegalStateException("Все коробки пусты или содержат нечисловые значения.");
        }
        return maxValue;
    }

    public static <T, P> List<P> applyToEach(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
}