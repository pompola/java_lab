public class Stepen {
    public static double Stepen(String xStr, String yStr) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);
        return Math.pow(x, y);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Необходимо передать два аргумента: число X и число Y");
            return;
        }

        String xStr = args[0];
        String yStr = args[1];

        double result = Stepen(xStr, yStr);
        System.out.println(xStr + " в степени " + yStr + " равно " + result);
    }
}
