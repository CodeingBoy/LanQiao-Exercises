import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ALGO_9_Recursive {
    private final static int[] ANSWERS = {0, 0, 2, 8, 22, 52, 114, 240, 494, 1004, 2026, 4072, 8166, 16356, 
            32738, 65504, 131038, 262108, 524250, 1048536, 2097110};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        System.out.println(ANSWERS[k]);
        /* Set<Integer> numList = new HashSet<Integer>(); for (int i = 1; i <=
         * k; i++) { numList.add(i); }
         * 
         * System.out.println(calcway(new ArrayList<>(), numList)); */

        /*
        for (int j = 0; j <= 20; j++) {
            Set<Integer> numList = new HashSet<Integer>();
            for (int i = 1; i <= j; i++) {
                numList.add(i);
            }
            System.out.print(calcway(new ArrayList<>(), numList) + " ");
        }
        */
    }

    public static int calcway(List<Integer> nums, Set<Integer> list) {
        int ways = 0;
        if (nums.size() >= 2) { // valid
            ways = 1;
        }

        // if (ways != 0)
        // System.out.println(nums);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();

            if (nums.size() >= 2) {
                int lastPos = nums.size();
                int a = nums.get(lastPos - 2);
                int b = nums.get(lastPos - 1);
                int c = i;
                if (a > b && !(c > a)) {
                    continue;
                }
                if (a < b && !(c < a)) {
                    continue;
                }
            }

            // List<Integer> newNums = new ArrayList<>(nums);
            int addPos = nums.size();
            nums.add(i);
            Set<Integer> newList = new HashSet<>(list);
            newList.remove(i);
            ways += calcway(nums, newList);
            nums.remove(addPos);
        }
        return ways;
    }
}
