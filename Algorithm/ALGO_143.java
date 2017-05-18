import java.util.Scanner;

public class ALGO_143 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        String string = scanner.nextLine().trim();

        switch (operation) {
        case 1:
            System.out.println(toUpper(string));
            break;
        case 2:
            System.out.println(toLower(string));
            break;
        case 3:
            System.out.println(reverse(string));
            break;
        case 4:
            System.out.println(reverseCase(string));
            break;
        case 5:
            System.out.println(convert(toLower(string)));
            break;
        default:
            break;
        }
    }

    public static String convert(String string) {
        StringBuffer buffer = new StringBuffer();
        char[] chars = string.toCharArray();
        buffer.append(chars[0]);

        char lastChar = chars[0], continuousCount = 0;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c - lastChar == 1) {
                continuousCount++;
            } else {
                if (continuousCount > 0) {
                    if (continuousCount > 1) {
                        buffer.append("-");
                    }
                    buffer.append((char) (chars[i - 1 - continuousCount] + continuousCount));

                    continuousCount = 0;
                }

                buffer.append(c);
            }
            lastChar = c;
        }
        if (continuousCount > 0) {
            if (continuousCount > 1) {
                buffer.append("-");
            }
            buffer.append((char) (chars[chars.length - 1 - continuousCount] + continuousCount));

            continuousCount = 0;
        }

        return buffer.toString();
    }

    public static String toLower(String string) {
        StringBuffer buffer = new StringBuffer();
        for (char c : string.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                buffer.append((char) (c - 'A' + 'a'));
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    public static String toUpper(String string) {
        StringBuffer buffer = new StringBuffer();
        for (char c : string.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                buffer.append((char) (c - 'a' + 'A'));
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    public static String reverse(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }

    public static String reverseCase(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                chars[i] = (char) (c - 'a' + 'A');
            } else {
                chars[i] = (char) (c - 'A' + 'a');
            }
        }
        return new String(chars);
    }
}
