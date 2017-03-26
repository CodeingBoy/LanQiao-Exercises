import java.util.Scanner;

public class BASIC_19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String string = scanner.next();

        if (!isPotentialRepeatString(string)) {
            System.out.println("Impossible");
            System.exit(0);
        }

        char[] chars = string.toCharArray();
        int swapCount = 0;

        for (int i = 0; i < Math.ceil(chars.length / 2); i++) {
            char curChar = chars[i];
            int swapIndex = -1;
            for (int j = chars.length - 1 - i; j > i; j--) {
                if (chars[j] == curChar) {
                    swapIndex = j;
                    break;
                }
            }
            if (swapIndex == -1) {
                char temp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = temp;
                i--;

                swapCount++;
                continue;
            }
            while (swapIndex != chars.length - 1 - i) {
                char temp = chars[swapIndex + 1];
                chars[swapIndex + 1] = chars[swapIndex];
                chars[swapIndex] = temp;
                swapIndex++;
                swapCount++;
            }
            //System.out.println(new String(chars));
        }
        System.out.println(swapCount);
    }

    public static boolean isPotentialRepeatString(String string) {
        boolean allowOdd = string.length() % 2 != 0;
        int[] charCount = new int[26];

        for (char c : string.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int i : charCount) {
            if (i % 2 != 0) {
                if (!allowOdd) {
                    return false;
                } else {
                    allowOdd = false;
                }
            }
        }
        return true;
    }
}
