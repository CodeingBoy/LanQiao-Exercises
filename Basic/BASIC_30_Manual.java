import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BASIC_30_Manual {
    private static class BigInt {
        private ArrayList<Integer> nums = new ArrayList<>();

        public BigInt(int[] digits) {
            for (int integer : digits) {
                nums.add(integer);
            }
        }

        public BigInt(List digits) {
            nums.addAll(digits);
        }

        public BigInt(BigInt obj) {
            this.nums = obj.getNums();
        }

        public BigInt(long num) {
            this.nums = getDigits(num);
        }

        public BigInt multiple(BigInt num) {
            ArrayList<Integer> arrayA = this.getNums(), arrayB = num.getNums();

            int length = Math.max(arrayA.size(), arrayB.size());
            int[] numA = new int[length];
            int maxOffset = length + arrayB.size() - 1;
            int[] result = new int[maxOffset];

            for (int i = 0; i < arrayA.size(); i++) {
                numA[length - 1 - i] = arrayA.get(arrayA.size() - 1 - i);
            }

            for (int index = 0; index < arrayB.size(); index++) {
                int offset = index;
                int digitB = arrayB.get(index);

                int[] tempResult = new int[length];
                int[] tempCarry = new int[length];
                int topCarry = 0;
                for (int i = length - 1; i >= 0; i--) {
                    int multipleResult = numA[i] * digitB + tempCarry[i];
                    tempResult[i] = multipleResult % 10;
                    if (i != 0) {
                        tempCarry[i - 1] = multipleResult / 10;
                    } else {
                        topCarry = multipleResult / 10;
                    }
                }

                int[] finalResult = new int[maxOffset];
                System.arraycopy(tempResult, 0, finalResult, offset, length);
                if (offset > 0) {
                    finalResult[offset - 1] = topCarry;
                } else {

                }

                // for (int i : finalResult) {
                // System.out.print(i);
                // }
                // System.out.println();

                result = add(result, finalResult);

                // for (int i : result) {
                // System.out.print(i);
                // }
                // System.out.println();
            }

            BigInt result_BigInt = new BigInt(result);

            return result_BigInt;
        }

        private int[] add(int[] numA, int[] numB) {
            int length = Math.max(numA.length, numB.length);
            if (numA.length != length) {
                int[] temp = new int[length];
                System.arraycopy(numA, 0, temp, length - numA.length, numA.length);
                numA = temp;
            }
            if (numB.length != length) {
                int[] temp = new int[length];
                System.arraycopy(numB, 0, temp, length - numB.length, numB.length);
                numB = temp;
            }

            int[] result = new int[length + 1];
            int[] carry = new int[length];

            int topCarry = 0;
            for (int i = length - 1; i >= 0; i--) {
                int sum = numA[i] + numB[i] + carry[i];
                result[i + 1] = sum % 10;
                if (i != 0) {
                    carry[i - 1] = sum / 10;
                } else {
                    result[0] = topCarry;
                }
            }

            return result;
        }

        private ArrayList<Integer> getDigits(long num) {
            ArrayList<Integer> result = new ArrayList<>();

            while (num > 0) {
                result.add(0, (int) num % 10);
                num /= 10;
            }
            return result;
        }

        public ArrayList<Integer> getNums() {
            return nums;
        }

        public void setNums(ArrayList<Integer> nums) {
            this.nums = nums;
        }

        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            boolean isTop = true;
            for (Integer integer : nums) {
                if (isTop && integer == 0) {
                    continue;
                }
                isTop = false;
                buffer.append(integer);
            }
            return buffer.toString();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        BigInt result = new BigInt(1);
        for (int i = 1; i <= num; i++) {
            result = result.multiple(new BigInt(i));
        }
        System.out.println(result);
    }
}
