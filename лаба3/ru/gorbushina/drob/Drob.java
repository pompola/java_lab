package ru.gorbushina.drob;

public final class Drob extends Number implements Cloneable {
    private final int numerator; // числитель
    private final int denominator; // знаменатель

    public Drob(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Реализуем абстрактные методы Number
    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    // Методы для операций с дробями
    public Drob sum(Drob other) {
        return new Drob(this.numerator * other.denominator + this.denominator * other.numerator,
                this.denominator * other.denominator);
    }

    public Drob minus(Drob other) {
        return new Drob(this.numerator * other.denominator - this.denominator * other.numerator,
                this.denominator * other.denominator);
    }

    public Drob multiply(Drob other) {
        return new Drob(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Drob divide(Drob other) {
        return new Drob(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    // Метод для сложения дроби с целым числом
    public Drob sum(int number) {
        return new Drob(this.numerator + this.denominator * number, this.denominator);
    }

    // Метод для вычитания целого числа из дроби
    public Drob minus(int number) {
        return new Drob(this.numerator - this.denominator * number, this.denominator);
    }

    // Метод для умножения дроби на целое число
    public Drob multiply(int number) {
        return new Drob(this.numerator * number, this.denominator);
    }

    // Метод для деления дроби на целое число
    public Drob divide(int number) {
        return new Drob(this.numerator, this.denominator * number);
    }

    // Переопределенный метод клонирования
    @Override
    public Drob clone() {
        try {
            return (Drob) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Не должно быть исключений, так как класс реализует Cloneable
        }
    }
}

