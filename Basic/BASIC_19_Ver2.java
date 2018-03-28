import java.util.Arrays;
import java.util.Scanner;

public class BASIC_19_Ver2 {
    private final static boolean debug = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        scanner.nextLine();
        final String input = scanner.nextLine();

        int[] charsCount = new int[128];
        if (!canBeMirroredString(input, charsCount)) {
            System.out.println("Impossible");
            return;
        }

        int totalTimes = 0;
        // construct mirrored string
        char[] buffer = input.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (char c : buffer) {
            if (charsCount[c] >= 2) {
                int times = charsCount[c] -= 2;
                builder.append(c);
            }
        }
        String half = builder.toString();
        if (input.length() % 2 != 0) {
            for (int i = 0; i < charsCount.length; i++) {
                if (charsCount[i] % 2 != 0) {
                    builder.append((char) i);
                }
            }
        }
        for (int i = half.length() - 1; i >= 0; i--) {
            builder.append(half.charAt(i));
        }
        if (debug) {
            System.out.println("Target string: " + builder.toString());
        }

        // swapping
        String target = builder.toString();
        for (int i = 0; i < input.length(); i++) {
            char expectedChar = target.charAt(i);
            int expectedPos = buffer.length - 1 - i;
            if (debug) {
                System.out.println("Current pos: " + i + ", opposite pos: " + expectedPos + ", expecting char: "
                        + expectedChar + ", got char: " + buffer[expectedPos]);
            }
            if (buffer[expectedPos] != expectedChar) {
                for (int j = buffer.length - 1 - i; j >= 0; j--) {
                    if (buffer[j] == expectedChar) {
                        if (debug) {
                            System.out.println("Found expected char(" + expectedChar + ") on " + j + ", swapping with "
                                    + expectedPos + "(" + buffer[expectedPos] + ")");
                        }
                        swap(buffer, j, expectedPos);
                        totalTimes += Math.abs(expectedPos - j);
                        if (debug) {
                            System.out.println("After swapping:" + Arrays.toString(buffer) + ", distance: " + Math.abs(expectedPos - j));
                        }
                        break;
                    }
                }
            }
        }

        if(debug) {
            System.out.println(Arrays.toString(buffer));
        }
        System.out.println(totalTimes);
    }

    private static void swap(char[] chars, int src, int dest) {
        if (src > dest) {
            int temp = src;
            src = dest;
            dest = temp;
        }

        char c = chars[src];
        for (int i = src; i < dest; i++) {
            chars[i] = chars[i + 1];
        }
        chars[dest] = c;
    }

    public static boolean isMirroredString(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            char left = string.charAt(i);
            char right = string.charAt(string.length() - 1 - i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }

    public static boolean canBeMirroredString(String string, int[] charsCount) {
        // int[] charsCount = new int[128];
        for (char c : string.toCharArray()) {
            charsCount[c]++;
        }

        boolean even = string.length() % 2 == 0;
        for (int i = 0; i < charsCount.length; i++) {
            int j = charsCount[i];
            if (j % 2 != 0) {
                if (!even) {
                    even = true;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
