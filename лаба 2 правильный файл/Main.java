import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер задачи (1-4):");
        int taskNumber = scanner.nextInt();

        switch (taskNumber) {
            case 1:
                // Задача 1.3
                Name cleopatra = new Name(null, "Клеопатра", null);
                Name pushkin = new Name("Пушкин", "Александр", "Сергеевич");
                Name mayakovsky = new Name("Маяковский", "Владимир", null);
                Name christopher = new Name("Бонифатьевич", "Христофор");

                System.out.println("для задания 1:");
                System.out.println(cleopatra);
                System.out.println(pushkin);
                System.out.println(mayakovsky);
                System.out.println("для задания 4:");
                System.out.println(christopher);
                break;

            case 2:
                // Задача 1.5
                Home home1 = new Home(1);
                Home home5 = new Home(5);
                Home home23 = new Home(23);

                System.out.println(home1.getTextForm());
                System.out.println(home5.getTextForm());
                System.out.println(home23.getTextForm());
                break;

            case 3:
                // Задача 2
                // Создаем отдел IT
                Department itDepartment = new Department("IT");

                // Создаем работников
                Worker petrov = new Worker("Петров");
                Worker kozlov = new Worker("Козлов");
                Worker sidorov = new Worker("Сидоров");

                // Назначаем работников в отдел IT
                petrov.setDepartment(itDepartment);
                kozlov.setDepartment(itDepartment);
                sidorov.setDepartment(itDepartment);

                // Назначаем Козлова начальником IT отдела
                itDepartment.setHead(kozlov);

                // Выводим информацию о работниках
                System.out.println("для задания 2:");
                System.out.println(petrov); // Петров работает в отделе IT, начальник которого Козлов
                System.out.println(kozlov); // Козлов начальник отдела IT
                System.out.println(sidorov); // Сидоров работает в отделе IT, начальник которого Козлов

                itDepartment.addWorker(petrov);
                itDepartment.addWorker(kozlov);
                itDepartment.addWorker(sidorov);

                System.out.println("для задания 3:");
                List<Worker> itWorkers = kozlov.getDepartmentWorkers();
                for (Worker worker : itWorkers) {
                    System.out.println(worker.getName());
                }
                break;

            case 4:
                // Задача 5
                Drob f1 = new Drob(1, 3);
                Drob f2 = new Drob(2, 3);
                Drob f3 = new Drob(3, 4);

                // Примеры использования методов:
                System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
                System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
                System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
                System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
                System.out.println(f1 + " + 2 = " + f1.sum(2));
                System.out.println(f1 + " - 2 = " + f1.minus(2));
                System.out.println(f1 + " * 2 = " + f1.multiply(2));
                System.out.println(f1 + " / 2 = " + f1.divide(2));

                // Вычисление f1.sum(f2).div(f3).minus(5)
                Drob result = f1.sum(f2).divide(f3).minus(5);
                System.out.println(f1 + " + " + f2 + " / " + f3 + " - 5 = " + result);
                break;

            default:
                System.out.println("Неверный номер задачи.");
        }
    }
}