import java.util.Scanner;

public class BASIC_29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string_a = scanner.nextLine();
        String string_b = scanner.nextLine();

        int length = Math.max(string_a.length(), string_b.length());
        int[] numA = new int[length], numB = new int[length];
        int[] result = new int[length];
        int[] carry = new int[length];

        for (int i = 0; i < string_a.length(); i++) {
            numA[length - 1 - i] = string_a.charAt(string_a.length() - 1 - i) - '0';
        }

        for (int i = 0; i < string_b.length(); i++) {
            numB[length - 1 - i] = string_b.charAt(string_b.length() - 1 - i) - '0';
        }

        // for (int i : numA) {
        // System.out.print(i);
        // }
        // System.out.println();
        //
        // for (int i : numB) {
        // System.out.print(i);
        // }
        // System.out.println();

        int topCarry = 0;
        for (int i = length - 1; i >= 0; i--) {
            int sum = numA[i] + numB[i] + carry[i];
            result[i] = sum % 10;
            if (i != 0) {
                carry[i - 1] = sum / 10;
            } else {
                topCarry = sum / 10;
            }
        }
        
        if (topCarry > 0) {
            System.out.print(topCarry);
        }
        for (int i : result) {
            System.out.print(i);
        }

    }
}
