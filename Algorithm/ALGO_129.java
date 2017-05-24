public class ALGO_129 {
    public static void main(String[] args) {
        for (int i = 1000; i < 10000; i++) {
            if (isSpecialNum(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isSpecialNum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            sum += digit;
        }
        return sum == 10;
    }
}
