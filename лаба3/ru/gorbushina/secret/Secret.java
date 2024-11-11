package ru.gorbushina.secret;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Secret { // Изменено на "public class"
    private String text;
    private String keeperName; //хранитель секрета - тоесть чей он
    private List<String> keepers = new ArrayList<>();

    // Конструктор для создания нового секрета
    public Secret(String keeperName, String text) {
        this.keeperName = keeperName;
        this.text = text;
        keepers.add(keeperName);
    }

    // Конструктор для передачи секрета другому человеку
    public Secret(Secret previousSecret, String newKeeperName) {
        this.keeperName = newKeeperName;
        this.text = previousSecret.text;
        keepers = new ArrayList<>(previousSecret.keepers);
        keepers.add(newKeeperName);

        // Добавление случайных символов
        Random random = new Random();
        int numChars = (int) Math.round(text.length() * 0.1);
        for (int i = 0; i < numChars; i++) {
            int index = random.nextInt(text.length());
            char randomChar = (char) (random.nextInt(26) + 'a');
            text = text.substring(0, index) + randomChar + text.substring(index);
        }
        System.out.println(previousSecret.keeperName + " сказал(а), что " + previousSecret.text);
    }

    // Получение имени хранителя секрета
    public String getKeeperName() {
        return keeperName;
    }

    // Получение номера хранителя секрета
    public int getKeeperNumber() {
        return keepers.indexOf(keeperName) + 1;
    }

    // Получение количества людей, знающих секрет после текущего
    public int getRemainingKeepers() {
        return keepers.size() - getKeeperNumber();
    }

    // Получение имени N-го человека, знавшего секрет
    public String getKeeperName(int n) {
        int index = getKeeperNumber() + n - 1;
        if (index >= 0 && index < keepers.size()) {
            return keepers.get(index);
        } else {
            return null;
        }
    }

    // Получение разницы в количестве символов текста секрета с N-ым человеком
    public int getSecretLengthDifference(int n) {
        String otherSecret = getKeeperName(n) != null ? getKeeperName(n) : "";
        return text.length() - otherSecret.length();
    }
    // Строковое представление объекта
    @Override
    public String toString() {
        return keeperName + ": никому не говори, это секрет!";
    }

    // Получение текста секрета (только при инициализации)
    private String getText() {
        return text;
    }
}

