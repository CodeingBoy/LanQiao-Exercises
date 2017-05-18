public class ALGO_63 {
    public static void main(String[] args) {
        for (int left = 1; left <= 9; left++) {
            for (int right = 1; right <= left; right++) {
                System.out.printf("%d*%d=%d", left, right, left * right);
                if (right != left) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}