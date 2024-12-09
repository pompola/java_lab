import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
    private String name;
    private Integer number;

    public Person(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}

class Group {
    private Map<Integer, List<String>> groupedPeople;

    public Group(Map<Integer, List<String>> groupedPeople) {
        this.groupedPeople = groupedPeople;
    }

    public Map<Integer, List<String>> getGroupedPeople() {
        return groupedPeople;
    }

    @Override
    public String toString() {
        return groupedPeople.toString();
    }


    public static Group processFile(String filePath) throws IOException {
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    try {
                        int number = Integer.parseInt(parts[1].trim());
                        people.add(new Person(name, number));
                    } catch (NumberFormatException e) {
                        // Игнорируем ошибку преобразования номера
                    }
                }
            }
        }

        Map<Integer, List<String>> groupedPeople = people.stream()
                .filter(p -> p.getNumber() != null)
                .map(p -> new Person(capitalize(p.getName().toLowerCase()), p.getNumber()))
                .collect(Collectors.groupingBy(Person::getNumber,
                        Collectors.mapping(Person::getName, Collectors.toList())));

        return new Group(groupedPeople);
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

