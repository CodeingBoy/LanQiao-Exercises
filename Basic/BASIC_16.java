import java.util.ArrayList;
import java.util.Scanner;

public class BASIC_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        ArrayList<Integer> primeNums = getPrimeNum(b);
        // System.out.println(primeNums);
        for (int i = a; i <= b; i++) {
            int temp = i;
            int curIndex = primeNums.size() - 1;

            while (curIndex >= 0 && primeNums.get(curIndex) > i) {
                curIndex--;
            }

            ArrayList<Integer> factors = new ArrayList<>();
            while (temp > 0 && curIndex >= 0) {
                int curFactor = primeNums.get(curIndex);
                if (temp % curFactor == 0) {
                    factors.add(0, curFactor);
                    temp /= curFactor;
                } else {
                    curIndex--;
                }
            }

            StringBuffer buffer = new StringBuffer();

            buffer.append(i + "=");

            for (Integer integer : factors) {
                buffer.append(integer + "*");
            }

            String result = buffer.toString();
            if (result.endsWith("*")) {
                result = result.substring(0, result.length() - 1);
            }

            System.out.println(result);
        }

    }

    public static ArrayList<Integer> getPrimeNum(int num) {
        int[] nums = new int[num + 1];
        for (int i = 2; i <= num; i++) {
            nums[i] = i;
        }
        for (int i = 2; i <= Math.ceil(Math.sqrt(num)); i++) {
            if (isPrimeNum(i)) {
                for (int j = i * i; j < nums.length; j += i) {
                    nums[j] = -1;
                }
            }
        }

        ArrayList<Integer> primeNums = new ArrayList<>();

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > 0) {
                primeNums.add(i);
            }
        }

        return primeNums;
    }

    public static boolean isPrimeNum(int num) {
        for (int i = 23; i <= Math.ceil(Math.sqrt(num)); i++) {
            if (num != i && num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
