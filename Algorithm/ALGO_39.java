import java.util.Scanner;

public class ALGO_39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        quickSort(nums, 0, 10);
        /* for (int i = 0; i < 10; i++) { System.out.print(nums[i] + " "); }
         * System.out.println(); */

        int lastNum = nums[0];
        System.out.println(lastNum);
        for (int i = 1; i < 10; i++) {
            if (nums[i] != lastNum) {
                System.out.println(nums[i]);
                lastNum = nums[i];
            }
        }
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int pivot = nums[start];
        int left = start, right = end - 1;
        while (left < right) {
            while (left < right && nums[right] >= pivot)
                right--;
            while (left < right && nums[left] <= pivot)
                left++;

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[start] = nums[left];
        nums[left] = pivot;

        quickSort(nums, start, left);
        quickSort(nums, left + 1, end);
    }
}
