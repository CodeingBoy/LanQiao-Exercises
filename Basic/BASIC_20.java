import java.util.ArrayList;
import java.util.Scanner;

public class BASIC_20 {
    final static String[] numsPinyin = { "ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "shi" };
    final static String[] unitsPinyin = { "", "shi", "bai", "qian", "wan", "wan", "wan", "wan", "yi", "yi", "yi",
            "yi" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();

        long thousandsNum = num % 10000;
        long billionsNum = num % (10000 * 10000) / 10000;
        long hundredMillionNum = num / (10000 * 10000);

        StringBuffer buffer = new StringBuffer();

        if (hundredMillionNum > 0) {
            buffer.append(getTenNumPinyin((int) hundredMillionNum, true) + " ");
            buffer.append("yi ");
        }

        if (billionsNum > 0) {
            Integer[] digits = getDigits(billionsNum);

            boolean appendedZero = false;
            if (digits[0] > 0) {
                buffer.append(numsPinyin[digits[0]] + " ");
                buffer.append("qian ");
            } else {
                if (hundredMillionNum != 0) {
                    buffer.append("ling ");
                    appendedZero = true;
                }
            }

            if (digits[1] > 0) {
                buffer.append(numsPinyin[digits[1]] + " ");
                buffer.append("bai ");
            } else {
                if (hundredMillionNum != 0 && digits[0] > 0 && !appendedZero) {
                    buffer.append("ling ");
                    appendedZero = true;
                }
            }

            long tensNum = billionsNum % 100;
            boolean isTop = hundredMillionNum == 0;
            buffer.append(getTenNumPinyin((int) tensNum, isTop) + " ");
            buffer.append("wan ");
        } else {
            if (hundredMillionNum != 0 && thousandsNum != 0) {
                buffer.append("ling ");
            }
        }

        if (thousandsNum > 0) {
            Integer[] digits = getDigits(thousandsNum);

            boolean appendedZero = false;
            if (digits[0] > 0) {
                buffer.append(numsPinyin[digits[0]] + " ");
                buffer.append("qian ");
            } else {
                if (billionsNum != 0) {
                    buffer.append("ling ");
                    appendedZero = true;
                }
            }

            if (digits[1] > 0) {
                buffer.append(numsPinyin[digits[1]] + " ");
                buffer.append("bai ");
            } else {
                if (digits[0] > 0 && thousandsNum % 100 != 0 && !appendedZero) {
                    buffer.append("ling ");
                    appendedZero = true;
                }
            }

            long tensNum = thousandsNum % 100;
            boolean isTop = hundredMillionNum == 0 && billionsNum == 0 && (digits[0] == 0 && digits[1] == 0);
            buffer.append(getTenNumPinyin((int) tensNum, isTop) + " ");
        }

        System.out.println(buffer.toString().trim());

    }

    public static String getTenNumPinyin(int num, boolean isTop) {
        int ten = num / 10;
        int one = num % 10;
        if (ten > 1) {
            if (num % 10 == 0)
                return numsPinyin[ten] + " shi";
            else
                return numsPinyin[ten] + " shi " + numsPinyin[one];
        } else if (ten == 1) {
            if (num == 10) {
                if (!isTop)
                    return "yi shi";
                else
                    return "shi";
            } else {
                return " shi " + numsPinyin[one];
            }
        } else {
            if (num == 0)
                return "";
            else
                return numsPinyin[one];
        }
    }

    public static Integer[] getDigits(long num) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(0, (int) num % 10);
            num /= 10;
        }
        while (digits.size() % 4 != 0) {
            digits.add(0, 0);
        }

        return digits.toArray(new Integer[0]);
    }

    public static Integer[] getDigits(String num) {
        return getDigits(Long.parseLong(num));
    }
}
