import java.util.Scanner;
import static java.lang.Math.abs;
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Scanner vvod = new Scanner(System.in);
/* 1.1*/
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        m.sumLastNums(x);
/* 1.2
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        m.isPositive(x);*/

/* 1.3
        System.out.print("Введите латинскую букву: ");
        char x = vvod.next().charAt(0);
        m.isUpperCase(x);*/

/* 1.4
        System.out.print("Введите а: ");
        int a = vvod.nextInt();
        System.out.print("Введите b: ");
            int b = vvod.nextInt();
        m.isDivisor(a, b);*/
/*1.5
        System.out.print("Введите а: ");
        int a = vvod.nextInt();
        for (int i = 0; i < 5; i++) {
            System.out.print("Введите b: ");
            int b = vvod.nextInt();
            a = m.lastNumSum(a, b);
            System.out.println("Итого: " + a);*/
        /* 2.1
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        System.out.print("Введите y: ");
        int y = vvod.nextInt();
        m.safeDiv (x, y);*/

/* 2.2
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        System.out.print("Введите y: ");
        int y = vvod.nextInt();
        m.makeDecision(x,y);*/

/* 2.3
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        System.out.print("Введите y: ");
        int y = vvod.nextInt();
        System.out.print("Введите z: ");
        int z = vvod.nextInt();
        m.sum3 (x, y, z);*/

/* 2.4
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        m.age(x);*/

/*2.5
        System.out.print("Введите название дня недели: ");
        String x = vvod.nextLine();
        m.printDays(x);*/

        /* 3.1
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        m.reverseListNums (x);*/

/* 3.2
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        System.out.print("Введите y: ");
        int y = vvod.nextInt();
        m.pow(x,y);*/

/* 3.3
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        m.equalNum(x);*/

/* 3.4
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        m.leftTriangle(x);*/

/*3.5
        m.guessGame();*/

        /*Random random = new Random();
        int[] arr = new int[10]; // создаем рандомный массив
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(-10);
        }
        System.out.print("Массив: "); // выводим массив
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();*/
/* 4.1
        System.out.print("Введите число для поиска: ");
        int x = vvod.nextInt();
        m.findLast(arr, x);*/
/* 4.2
        System.out.print("Введите позицию: ");
        int pos = vvod.nextInt();
        System.out.print("Введите x: ");
        int x = vvod.nextInt();
        m.add(arr, x, pos);*/

/* 4.3
        m.reverse(arr);*/

/* 4.4
        int[] arr2 = new int[10]; // создаем рандомный массив
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(10);
        }
        System.out.print("Массив2: "); // выводим массив
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        m.concat(arr, arr2);*/

/*4.5
        int[] arr  = {-1, 2, -3, 4, 5, -12};
        int [] result = m.deleteNegative(arr);
        System.out.print("Положительный массив: ");
        for (int i : result) { // Цикл для вывода элементов массива
            System.out.print(i + " ");
        }*/
    }


    public int sumLastNums(int x) {

        if (x < 10 && (-10) < x) {
            System.out.println("Должно быть не менее 2 знаков");
        } else {
            int y = x % 10;
            int z = (x / 10) % 10;
            System.out.println(abs(y + z));

        }
        return x;
    }

    public boolean isPositive(int x) {
        if (x > 0) {
            System.out.println("true");
            return true;
        } else if (x < 0) {
            System.out.println("false");
            return false;
        } else {
            System.out.println("это 0, что ты от него хочешь то?");
            return false;
        }
    }

    public boolean isUpperCase(char x) {
        if (Character.isLetter(x)) {
            if(Character.isUpperCase(x)) {
                System.out.println("true");
                return true;
            } else{
                System.out.println("false");
                return false;
            }
        } else {
            System.out.println("это не буква");
            return false;
        }
    }
    public boolean isDivisor (int a, int b) {
        if (a%b == 0) {
            System.out.println("true");
            return true;
        } else if (b%a == 0) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
    public int lastNumSum(int a, int b) {
        a = (a % 10) + (b % 10);
        return a;
    }

    public double safeDiv (int x, int y) {
        if (y == 0) {
            System.out.println(0);
            return 0;
        } else {
            System.out.println(x/y);
            return (x/y);
        }
    }

    public String makeDecision (int x, int y) {
        if (x > y) {
            System.out.println(x + ">" + y);
        } else if (x < y) {
            System.out.println(x + "<" + y);
        } else {
            System.out.println(x + "=" + y);
        }
        return "";
    }

    public boolean sum3 (int x, int y, int z) {
        if (x + y == z) {
            System.out.println("true");
        } else if (x + z == y) {
            System.out.println("true");
        } else if (y + z == x) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        return false;
    }

    public String age (int x) {
        if (x % 10 == 1 && x != 11) {
            System.out.println(x + " год");
        } else if (x % 10 == 2 || x % 10 == 3 || x % 10 == 4 || x != 12 || x != 13 || x != 14) {
            System.out.println(x + " года");
        } else {
            System.out.println(x + " лет");
        }
        return "";
    }

    public void printDays (String x) {
        switch (x) {
            case "понедельник":
                System.out.println("понедельник");
                System.out.println("вторник");
                System.out.println("среда");
                System.out.println("четверг");
                System.out.println("пятница");
                System.out.println("суббота");
                System.out.println("воскресенье");
                break;
            case "вторник":
                System.out.println("вторник");
                System.out.println("среда");
                System.out.println("четверг");
                System.out.println("пятница");
                System.out.println("суббота");
                System.out.println("воскресенье");
                break;
            case "среда":
                System.out.println("среда");
                System.out.println("четверг");
                System.out.println("пятница");
                System.out.println("суббота");
                System.out.println("воскресенье");
                break;
            case "четверг":
                System.out.println("четверг");
                System.out.println("пятница");
                System.out.println("суббота");
                System.out.println("воскресенье");
                break;
            case "пятница":
                System.out.println("пятница");
                System.out.println("суббота");
                System.out.println("воскресенье");
                break;
            case "суббота":
                System.out.println("суббота");
                System.out.println("воскресенье");
                break;
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }

    public String reverseListNums(int x) {
        for (int i = x; i >= 0; i--) {
            System.out.print(i + " ");
        }
        return "";
    }

    public int pow(int x, int y) {
        int s = 1;
        for (int i = 1; i <= y; i++) {
            s *= x;
        }
        System.out.print(s);
        return s;
    }

    public boolean equalNum(int x) {
        Scanner vvod = new Scanner(System.in);
        x = abs(x);
        int i = x % 10; // первая цифра
        x /= 10;
        while (x > 0) {
            if (x % 10 != i) {
                System.out.print("false");
                return false;
            }
            x /= 10;
        }
        System.out.print("true");
        return true;
    }


    public void leftTriangle (int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void guessGame() {
        Random random = new Random();
        int secret = random.nextInt(10);
        int pop = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            pop++; //  счетчик попыток
            System.out.print("Введите число от 0 до 9: ");
            int x = scanner.nextInt(); // число пользователя

            if (x == secret) {
                System.out.println("Вы угадали!");
                break;
            } else {
                System.out.println("Вы не угадали.");
            }
        }
        System.out.println("Вы отгадали! Количество попыток: " + pop + "");
    }

    public int findLast (int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                System.out.print(i);
                return i;
            }
        }
        System.out.print("-1");
        return -1;
    }

    public int[]add (int[] arr, int x, int pos) {
        if (pos < 0 || pos > arr.length) {
            System.out.println("неккоректная позиция");
            return arr;
        } else {
            int[] newArr = new int[arr.length + 1];
            for (int i = 0; i < pos; i++) {
                newArr[i] = arr[i]; // элементы до позиции pos
            }
            newArr[pos] = x;
            for (int i = pos + 1; i < newArr.length; i++) {
                newArr[i] = arr[i - 1]; // оставшиеся элементы
            }
            System.out.print("Новый массив: "); // выводим массив
            for (int i = 0; i < newArr.length; i++) {
                System.out.print(newArr[i] + " ");
            }
            return newArr;
        }

    }

    public void reverse (int[] arr) {
        System.out.print("Массив наоборот: "); // выводим массив
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    public int[] concat (int[] arr,int[] arr2) {
        System.out.print("Новый массив: ");
        int[] result = new int[arr.length + arr2.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            result[i + arr.length] = arr2[i];
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
        return result;

    }

    public int[] deleteNegative (int[] arr) {
        int pos = 0;
        for (int i : arr) {
            if (i >= 0) {
                pos++;
            }
        }
        int[] result = new int[pos];
        int j = 0;
        for (int i : arr) {
            if (i >= 0) {
                result[j] = i;
                j++;
            }
        }
        return result;

    }
}