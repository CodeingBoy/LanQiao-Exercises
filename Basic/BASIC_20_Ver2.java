import java.util.Scanner;

public class BASIC_20_Ver2 {
    private final static String[] PINYINS_DIGIT = { "ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu" };
    private final static String[] PINYINS_UNITS = { "", "shi", "bai", "qian", "wan", "wan", "wan", "wan", "yi", "yi" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();

        StringBuilder builder = new StringBuilder();
        // hundred million -- yi
        int hundredMillions = (int) num / 100000000;
        num %= 100000000;
        if (hundredMillions != 0) {
            builder.append(getPinyin(hundredMillions) + " yi ");
        }

        // ten thousands -- wan
        int tenThousands = (int) (num / 10000);
        num %= 10000;
        if (tenThousands != 0) {
            builder.append(getPinyin(tenThousands, hundredMillions != 0) + " wan ");
        }

        // units
        int units = (int) (num % 10000);
        boolean unitsZero = (tenThousands != 0 && units < 1000 || hundredMillions != 0);
        builder.append(getPinyin(units, unitsZero));

        while (builder.toString().trim().startsWith("yi shi")) {
            builder.replace(0, 3, "");
        }
        while (builder.toString().trim().endsWith("ling")) {
            builder.replace(builder.length() - 5, builder.length(), "");
        }

        System.out.println(builder.toString().trim());
    }

    private static String getPinyin(int num, boolean shouldAddZero) {
        String result = getPinyin(num);
        if (shouldAddZero) {
            return PINYINS_DIGIT[0] + " " + result;
        }
        return result;
    }

    private static String getPinyin(int num) {
        int n = num;
        boolean addedZero = false;

        StringBuilder builder = new StringBuilder(" ");
        int thousands = num / 1000;
        num %= 1000;
        int hundreds = num / 100;
        num %= 100;
        int tens = num / 10;
        int units = num % 10;
        if (thousands != 0) {
            builder.append(getPinyin(thousands) + " qian ");
        }
        if (hundreds != 0) {
            builder.append(getPinyin(hundreds) + " bai ");
        } else if (n >= 1000) {
            builder.append(PINYINS_DIGIT[0] + " ");
            addedZero = true;
        }

        if (tens != 0) {
            if (tens > 1) {
                builder.append(PINYINS_DIGIT[tens] + " shi ");
            } else {
                builder.append("yi shi ");
            }
        } else if (n >= 100 && !addedZero) {
            builder.append(PINYINS_DIGIT[0] + " ");
            addedZero = true;
        }

        if (units != 0) {
            builder.append(PINYINS_DIGIT[units]);
        }

        return builder.toString().trim();
    }
}
