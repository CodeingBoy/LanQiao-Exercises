import java.util.Scanner;

public class ALGO_139_loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        System.out.println(transform("0", time));
    }

    public static String transform(String string, int times) {
        while (times > 0) {
            StringBuffer buffer = new StringBuffer();
            for (char c : string.toCharArray()) {
                if (c == '0') {
                    buffer.append("1");
                } else { // 1
                    buffer.append("01");
                }
            }
            string = buffer.toString();
            times--;
        }
        return string;
    }
}
