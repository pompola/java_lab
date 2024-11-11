package ru.gorbushina.home;

public class Home {
    private int countEtage;

    public Home(int countEtage) {              // проверка на отрицание !
        this.countEtage = countEtage;
    }

    public int getCountEtage() {
        return countEtage;
    }

    public String getTextForm() {
        String ending = getEtageEnding(countEtage);
        return "дом с " + countEtage + " этаж" + ending;
    }

    private String getEtageEnding(int countEtage) {
        if (countEtage % 10 == 1 && countEtage % 100 != 11) {
            return "ом"; // без окончания
        } else if (countEtage % 10 >= 2 && countEtage % 10 <= 4 &&
                (countEtage % 100 < 12 || countEtage % 100 > 14)) {
            return "ами";
        } else {
            return "ами";
        }
    }
}
