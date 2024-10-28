public class Drob {
    private int numerator;// числитель
    private int denominator; // знаменатель

    public Drob(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
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

    public Drob sum(int other) {
        return new Drob(this.numerator + this.denominator * other, this.denominator);
    }

    public Drob minus(int other) {
        return new Drob(this.numerator - this.denominator * other, this.denominator);
    }

    public Drob multiply(int other) {
        return new Drob(this.numerator * other, this.denominator);
    }

    public Drob divide(int other) {
        return new Drob(this.numerator, this.denominator * other);
    }
}
