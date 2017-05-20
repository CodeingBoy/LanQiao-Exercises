import java.util.Scanner;

// Same as ALGO_12
public class ALGO_95 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(divide(num));
    }

    public static String divide(int num) {
        if (num == 1) {
            return "2(0)";
        } else if (num == 2) {
            return "2";
        } else if (num == 0) {
            return "0";
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 15; i >= 0; i--) {
            int exp = (int) Math.pow(2, i);
            if (num >= exp) {
                num -= exp;
                if (i == 1) {
                    buffer.append("2+");
                } else {
                    buffer.append("2(" + divide(i) + ")+");
                }
            }
        }
        if (buffer.toString().endsWith("+")) {
            return buffer.substring(0, buffer.length() - 1);
        }
        return buffer.toString();
    }
}
