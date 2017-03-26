import java.util.Scanner;

public class BASIC_21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String result = getSn(1, n);
        if (result.startsWith("(")) {
            result = result.substring(1, result.length());
        }
        if (result.endsWith(")")) {
            result = result.substring(0, result.length() - 1);
        }
        System.out.println(result);
    }

    public static String getSine(int level, int finNum) {
        if (level == finNum) {
            return "sin(" + finNum + ")";
        }
        return "sin(" + level + (level % 2 != 0 ? "-" : "+") + getSine(level + 1, finNum);
    }

    public static String getSn(int level, int finNum) {
        if (level == finNum) {
            return "(" + getSine(1, 1) + "+" + finNum + ")";
        }
        return "(" + getSn(level + 1, finNum) + getSine(1, finNum - level + 1) + "+" + level + ")";
    }
}
