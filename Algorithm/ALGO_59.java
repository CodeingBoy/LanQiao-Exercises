import java.util.Scanner;

public class ALGO_59 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numCount = scanner.nextInt();
        int[] nums = new int[numCount];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        quickSort(nums, 0, numCount);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int left = start, right = end - 1;
        final int pivot = nums[start];
        while (left < right) {
            
            while (left < right && nums[left] <= pivot)
                left++;
            while (left < right && nums[right] >= pivot)
                right--;

            if (left < right) {
                final int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        int temp = nums[start];
        nums[start] = nums[left];
        nums[left] = temp;

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        quickSort(nums, start, left);
        quickSort(nums, left + 1, end);
    }
}
