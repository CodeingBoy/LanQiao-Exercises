import java.util.Scanner;

public class ALGO_33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radix = scanner.nextInt();
        int pos = scanner.nextInt();

        String binary = Integer.toBinaryString(pos);

        long result = 0;
        char[] chars = binary.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != '1')
                continue;

            int weight = chars.length - 1 - i;
            result += Math.pow(radix, weight);
        }

        System.out.println(result);
    }
}
