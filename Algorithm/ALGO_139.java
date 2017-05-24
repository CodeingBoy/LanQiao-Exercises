import java.util.Scanner;

public class ALGO_139 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        System.out.println(transform("0", time));
    }

    public static String transform(String string, int times) {
        if (times == 0) {
            return string;
        }
        StringBuffer buffer = new StringBuffer();
        for (char c : string.toCharArray()) {
            if (c == '0') {
                buffer.append("1");
            } else { // 1
                buffer.append("01");
            }
        }
        return transform(buffer.toString(), times - 1);
    }
}
