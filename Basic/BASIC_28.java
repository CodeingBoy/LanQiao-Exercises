import java.util.ArrayList;
import java.util.Scanner;

public class BASIC_28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        ArrayList<Integer> nums = new ArrayList<>();
        
        for(int i = 0;i < n;i++){
            nums.add(scanner.nextInt());
        }
        
        int weigh = 0;
        while(nums.size() > 1){
            int min = Integer.MAX_VALUE;
            int min_2 = Integer.MAX_VALUE;
            int min_index = -1, min_2_index = -1;
            
            for(int i = 0;i < nums.size();i++){
                Integer integer = nums.get(i); 
                if(integer < min){
                    min = integer;
                    min_index = i;
                }
            }
            nums.remove(min_index);
            
            for(int i = 0;i < nums.size();i++){
                Integer integer = nums.get(i); 
                if(integer < min_2){
                    min_2 = integer;
                    min_2_index = i;
                }
            }
            nums.remove(min_2_index);
            
            int newWeigh = min + min_2;
            weigh += newWeigh;
            
            nums.add(newWeigh);
        }
        System.out.println(weigh);
    }
}
