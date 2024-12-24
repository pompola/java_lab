import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер задачи (номера как в файле, только без точек):");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        switch (taskNumber) {
            case 1:
                B b = new B();
                System.out.println(b); // Вывод: B{text=B, s=hello, x=42}

                A a = new A();
                System.out.println(a); // Вывод: A{s=hello, x=42}
                break;

            case 21:
                // @Invoke
                System.out.println("Выполняем действия для аннотации @Invoke");
                AnotherClass anotherClass = new AnotherClass();
                Method[] methods = anotherClass.getClass().getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Invoke.class)) {
                        method.invoke(anotherClass); // Вызов метода с аннотацией
                    }
                }
                break;
            case 22:
                // @Default
                System.out.println("Выполняем действия для аннотации @Default");
                TestClassDefault testClassDefault = new TestClassDefault();
                if(testClassDefault.getClass().isAnnotationPresent(Default.class)){
                    Default annotation = testClassDefault.getClass().getAnnotation(Default.class);
                    System.out.println("Дефолтный класс: " + annotation.value().getSimpleName());
                }
                try {
                    java.lang.reflect.Field field = testClassDefault.getClass().getDeclaredField("number");
                    if(field.isAnnotationPresent(Default.class)){
                        Default annotation = field.getAnnotation(Default.class);
                        System.out.println("Дефолтный тип поля number: " + annotation.value().getSimpleName());
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                break;
            case 23:
                // @ToString
                System.out.println("Выполняем действия для аннотации @ToString");
                TestClassToString testClassToString = new TestClassToString();
                if(testClassToString.getClass().isAnnotationPresent(ToString.class)){
                    ToString annotation = testClassToString.getClass().getAnnotation(ToString.class);
                    System.out.println("Значение свойства ToString: " + annotation.value());
                }
                break;

            case 24:
                // @Validate
                System.out.println("Выполняем действия для аннотации @Validate");
                TestClassValidate testClassValidate = new TestClassValidate();
                if (testClassValidate.getClass().isAnnotationPresent(Validate.class)){
                    Validate annotation = testClassValidate.getClass().getAnnotation(Validate.class);
                    System.out.println("Валидные классы: " + Arrays.toString(annotation.value()));
                }
                break;
            case 25:
                // @Two
                System.out.println("Выполняем действия для аннотации @Two");
                TestClassTwo testClassTwo = new TestClassTwo();
                if(testClassTwo.getClass().isAnnotationPresent(Two.class)){
                    Two annotation = testClassTwo.getClass().getAnnotation(Two.class);
                    System.out.println("Свойство first: " + annotation.first());
                    System.out.println("Свойство second: " + annotation.second());
                }
                break;
            case 26:
                // @Cache
                System.out.println("Выполняем действия для аннотации @Cache");
                TestClassCache testClassCache = new TestClassCache();
                TestClassCacheValue testClassCacheValue = new TestClassCacheValue();
                if(testClassCache.getClass().isAnnotationPresent(Cache.class)){
                    Cache annotation = testClassCache.getClass().getAnnotation(Cache.class);
                    System.out.println("Свойство value: " + Arrays.toString(annotation.value()));
                }
                if(testClassCacheValue.getClass().isAnnotationPresent(Cache.class)){
                    Cache annotation = testClassCacheValue.getClass().getAnnotation(Cache.class);
                    System.out.println("Свойство value: " + Arrays.toString(annotation.value()));
                }
                break;

            case 3:

                D d = new D();
                System.out.println(d); // Выведет: D{s=hello}
                G g = new G();
                System.out.println(g);  // Выведет: G{text=G, anotherField=some data, s=hello}
                C c = new C();
                System.out.println(c); // Выведет: C{field2=100}
                break;

            case 4:

                break;

            default:
                System.out.println("Неверный номер задачи");
        }
    }
}
