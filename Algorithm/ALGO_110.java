import java.util.Scanner;

public class ALGO_110 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int param1 = scanner.nextInt(), param2 = scanner.nextInt(), param3 = scanner.nextInt();
            boolean useUpperCase = param1 == 2, fillStar = param1 == 3, shouldReverse = param3 == 2;
            String input = scanner.next();

            System.out.println(decompress(input, useUpperCase, fillStar, param2, shouldReverse));
        }
    }

    public static String decompress(String string, boolean useUpperCase, boolean fillStar, int fillCount,
            boolean shouldReverse) {
        StringBuffer buffer = new StringBuffer();
        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '-' && i < chars.length - 1 && buffer.length() > 1) {
                buffer = new StringBuffer(buffer.substring(0, buffer.length() - 1));
                i--;
            }

            if (i + 2 < chars.length && chars[i + 1] == '-') {
                char start = chars[i], end = chars[i + 2];

                if (!(Character.isDigit(start) && Character.isDigit(end))
                        && !(Character.isLowerCase(start) && Character.isLowerCase(end))) {
                    buffer.append(start + "-" + end);
                    i += 2;
                    continue;
                }

                // situation 5-1
                if (end - start == 1) {
                    buffer.append(start);
                    buffer.append(end);
                    i += 2;
                    continue;
                }

                // situation 5-2
                if (end <= start) {
                    buffer.append(start + "-" + end);
                    i += 2;
                    continue;
                }

                if (fillStar) { // situation 2-3
                    int distance = end - start - 1;
                    int starCount = fillCount * distance;
                    buffer.append(start);
                    for (int j = 0; j < starCount; j++) {
                        buffer.append('*');
                    }
                    buffer.append(end);
                } else { // situation 2-1, 2-2
                    StringBuffer temp = new StringBuffer();

                    char left = (char) (start + 1);
                    for (int j = left; j < end; j++) {
                        for (int k = 0; k < fillCount; k++) { // situation 3
                            temp.append((char) j);
                        }
                    }

                    if (useUpperCase) {
                        temp = new StringBuffer(temp.toString().toUpperCase());
                    } else {
                        temp = new StringBuffer(temp.toString().toLowerCase());
                    }

                    if (shouldReverse) {
                        temp = temp.reverse();
                    }

                    buffer.append(start);
                    buffer.append(temp.toString());
                    buffer.append(end);
                }
                i += 2;
            } else {
                buffer.append(chars[i]);
            }
        }

        return buffer.toString();
    }
}