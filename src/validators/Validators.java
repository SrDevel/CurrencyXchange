package validators;

public class Validators {
    public static boolean isPositiveFloat(String str) {
        return str.matches("\\d+\\.\\d+");
    }

    public static boolean isPositiveInteger(String str) {
        return str.matches("\\d+");
    }

    public static boolean isDoublePositive(String str) {
        return Double.parseDouble(str) > 0;
    }

    public static boolean isDoubleOutOfRange(String str, double min, double max) {
        return Double.parseDouble(str) >= min && Double.parseDouble(str) <= max;
    }

    public static boolean isIntegerOutOfRange(String str, int min, int max) {
        return Integer.parseInt(str) >= min && Integer.parseInt(str) <= max;
    }
}
