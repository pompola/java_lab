import java.io.Serializable;

interface DrobInterface {
    double getRealValue();
    void setNumerator(int numerator);
    void setDenominator(int denominator);
}

// главный конструктор
public final class Drob5 extends Number implements Cloneable, Serializable, DrobInterface {
    private final int numerator; // числитель
    private final int denominator; // знаменатель
    private Double cachedRealValue; // кэш для вещественного значения

// метод проверок
    public Drob5(int numerator, int denominator) {
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
// хеширование
    @Override
    public int hashCode() {
        return Integer.hashCode(numerator * 31 + denominator);

    }
// методы получения из интерфейса
    @Override
    public void setNumerator(int numerator) {
        throw new UnsupportedOperationException("Дробь неизменяема");
    }

    @Override
    public void setDenominator(int denominator) {
        throw new UnsupportedOperationException("Дробь неизменяема");
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

// абстрактные методы Number
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


    @Override
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = (double) numerator / denominator;
        }
        return cachedRealValue;
    }

// Методы для операций с дробями
    public Drob5 sum(Drob5 other) {
        return new Drob5(this.numerator * other.denominator + this.denominator * other.numerator,
                this.denominator * other.denominator);
    }

    public Drob5 minus(Drob5 other) {
        return new Drob5(this.numerator * other.denominator - this.denominator * other.numerator,
                this.denominator * other.denominator);
    }

    public Drob5 multiply(Drob5 other) {
        return new Drob5(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Drob5 divide(Drob5 other) {
        return new Drob5(this.numerator * other.denominator, this.denominator * other.numerator);
    }

// Методы для операций дроби с целым числом
    public Drob5 sum(int number) {
        return new Drob5(this.numerator + this.denominator * number, this.denominator);
    }

    public Drob5 minus(int number) {
        return new Drob5(this.numerator - this.denominator * number, this.denominator);
    }

    public Drob5 multiply(int number) {
        return new Drob5(this.numerator * number, this.denominator);
    }

    public Drob5 divide(int number) {
        return new Drob5(this.numerator, this.denominator * number);
    }

// метод сравнения
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Drob5 dro = (Drob5) obj;
        return numerator == dro.numerator && denominator == dro.denominator;
    }

}

