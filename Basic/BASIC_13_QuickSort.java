import java.util.Arrays;
import java.util.Scanner;

public class BASIC_13_QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();

        int[] nums = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            nums[i] = scanner.nextInt();
        }

        QuickSort(nums, 0, nums.length);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static void QuickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int pivot = nums[start];

        int left = start, right = end - 1;
        while (left < right) {
            while (left < right && nums[right] > pivot)
                right--;
            while (left < right && nums[left] <= pivot)
                left++;

            if (left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        int temp = nums[left];
        nums[left] = nums[start];
        nums[start] = temp;
        
        QuickSort(nums, start, left);
        QuickSort(nums, left + 1, end);
    }

}
