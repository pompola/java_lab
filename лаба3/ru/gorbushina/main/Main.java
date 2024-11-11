package ru.gorbushina.main;

import ru.gorbushina.drob.Drob;
import ru.gorbushina.name.Name;
import ru.gorbushina.secret.Secret;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер задачи (номера как в файле, только без точек):");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        switch (taskNumber) {
            case 8:
                Drob f10 = inputDrob(scanner, "f10");
                Drob f11 = f10.clone();

                System.out.println(f10);
                System.out.println(f11);

                f10.getNumerator();
                f11.getNumerator();
                break;
            case 6:
                Drob f7 = inputDrob(scanner, "f7");
                Drob f8 = inputDrob(scanner, "f8");
                Drob f9 = inputDrob(scanner, "f9");

                // Вывод исходных дробей
                System.out.println("f7: " + f7);
                System.out.println("f8: " + f8);
                System.out.println("f9: " + f9);

                // Примеры использования методов
                System.out.println(f7 + " * " + f8 + " = " + f7.multiply(f8));
                System.out.println(f7 + " + " + f8 + " = " + f7.sum(f8));
                System.out.println(f7 + " - " + f8 + " = " + f7.minus(f8));
                System.out.println(f7 + " / " + f8 + " = " + f7.divide(f8));
                System.out.println(f7 + " + 2 = " + f7.sum(2));
                System.out.println(f7 + " - 2 = " + f7.minus(2));
                System.out.println(f7 + " * 2 = " + f7.multiply(2));
                System.out.println(f7 + " / 2 = " + f7.divide(2));

                // Вычисление сложной операции
                Drob r = f7.sum(f8).divide(f9).minus(5);
                System.out.println(f7 + " + " + f8 + " / " + f9 + " - 5 = " + r);

                System.out.println("1 == 2: " + f7.equals(f8));
                System.out.println("1 == 3: " + f7.equals(f9));
                System.out.println("2 == 3: " + f8.equals(f9));
                break;

            case 5:
                double result1 = sum(2, 3.0 / 5, 2.3);
                System.out.println("1: " + result1);

                double result2 = sum(3.6, 49.0 / 12, 3, 3.0 / 2);
                System.out.println("2: " + result2);

                double result3 = sum(1.0 / 3, 1);
                System.out.println("3: " + result3);
                break;

            case 2:
                System.out.print("Введите имя хранителя секрета: ");
                String keeperName = scanner.nextLine();
                System.out.print("Введите текст секрета: ");
                String secretText = scanner.nextLine();
                Secret secret1 = new Secret(keeperName, secretText);
                System.out.println("Создан новый секрет: " + secret1);

                // Передача секрета другому человеку
                System.out.print("Введите имя нового хранителя секрета: ");
                String newKeeperName = scanner.nextLine();
                Secret secret2 = new Secret(secret1, newKeeperName);
                System.out.println("Секрет передан: " + secret2);

                // Получение информации о секрете
                System.out.println("Хранитель секрета: " + secret2.getKeeperName());
                System.out.println("Номер хранителя секрета: " + secret2.getKeeperNumber());
                System.out.println("Количество людей, знающих секрет после текущего: " + secret2.getRemainingKeepers());
                System.out.println("Имя следующего хранителя: " + secret2.getKeeperName(1));
                System.out.println("Имя предыдущего хранителя: " + secret2.getKeeperName(-1));
                System.out.println("Разница в количестве символов с предыдущим хранителем: " + secret2.getSecretLengthDifference(-1));

                scanner.close();
                break;

            case 3:
                Drob f4 = inputDrob(scanner, "f4");
                Drob f5 = inputDrob(scanner, "f5");
                Drob f6 = inputDrob(scanner, "f6");

                // Вывод исходных дробей
                System.out.println("f4: " + f4);
                System.out.println("f5: " + f5);
                System.out.println("f6: " + f6);

                // Примеры использования методов
                System.out.println(f4 + " * " + f5 + " = " + f4.multiply(f5));
                System.out.println(f4 + " + " + f5 + " = " + f4.sum(f5));
                System.out.println(f4 + " - " + f5 + " = " + f4.minus(f5));
                System.out.println(f4 + " / " + f5 + " = " + f4.divide(f5));
                System.out.println(f4 + " + 2 = " + f4.sum(2));
                System.out.println(f4 + " - 2 = " + f4.minus(2));
                System.out.println(f4 + " * 2 = " + f4.multiply(2));
                System.out.println(f4 + " / 2 = " + f4.divide(2));

                // Вычисление сложной операции
                Drob result = f4.sum(f5).divide(f6).minus(5);
                System.out.println(f4 + " + " + f5 + " / " + f6 + " - 5 = " + result);

                // Проверка: Изменились ли исходные дроби?
                System.out.println("f4 (после операций): " + f4); // Должно быть то же, что и исходная
                System.out.println("f5 (после операций): " + f5); // Должно быть то же, что и исходная
                System.out.println("f6 (после операций): " + f6); // Должно быть то же, что и исходная

                break;

            case 17:
                // Задача 1.7
                System.out.println("Введите фамилию (если есть):");
                String lastName = scanner.nextLine();

                System.out.println("Введите имя (если есть):");
                String firstName = scanner.nextLine();

                System.out.println("Введите отчество (если есть):");
                String middleName = scanner.nextLine();

                if (lastName.isEmpty() && firstName.isEmpty() && middleName.isEmpty()) {
                    System.out.println("Ошибка: По крайней мере одно из полей должно быть заполнено.");
                } else {
                    try {
                        Name name = new Name(lastName, firstName, middleName);
                        System.out.println("Полное имя: " + name);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }

                break;

            case 14:
                //Задача 1.4
                Drob f1 = inputDrob(scanner, "f1");
                Drob f2 = inputDrob(scanner, "f2");
                Drob f3 = inputDrob(scanner, "f3");

                // Примеры использования методов:
                System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
                System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
                System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
                System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
                System.out.println(f1 + " + 2 = " + f1.sum(2));
                System.out.println(f1 + " - 2 = " + f1.minus(2));
                System.out.println(f1 + " * 2 = " + f1.multiply(2));
                System.out.println(f1 + " / 2 = " + f1.divide(2));

                Drob res = f1.sum(f2).divide(f3).minus(5);
                System.out.println(f1 + " + " + f2 + " / " + f3 + " - 5 = " + res);

                break;

            default:
                System.out.println("Неверный номер задачи.");
        }
        scanner.close();
    }
    private static Drob inputDrob(Scanner scanner, String name) {
        while (true) {
            try {
                System.out.println("Введите числитель и знаменатель для дроби " + name + " (через пробел):");
                String[] input = scanner.nextLine().split(" ");
                if (input.length != 2) { // Проверка на наличие двух чисел
                    System.out.println("Некорректный ввод. Введите числитель и знаменатель через пробел.");
                    continue; // Повторить ввод
                }
                int numerator = Integer.parseInt(input[0]);
                int denominator = Integer.parseInt(input[1]);
                return new Drob(numerator, denominator);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целые числа.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static double sum(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }
}
