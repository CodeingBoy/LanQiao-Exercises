import java.util.Arrays;
import java.util.Scanner;

public class BASIC_13_Java {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();

        int[] nums = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            nums[i] = scanner.nextInt();
        }
        
        Arrays.sort(nums);
        
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }

}
