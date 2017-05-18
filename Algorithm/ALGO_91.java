import java.util.Scanner;

public class ALGO_91 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine().toLowerCase();
        String word2 = scanner.nextLine().toLowerCase();
        int[] times_word1 = new int[26];
        int[] times_word2 = new int[26];
        
        for (char c : word1.toCharArray()) {
            times_word1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            times_word2[c - 'a']++;
        }
        
        for (int i = 0; i < times_word1.length; i++) {
            if(times_word1[i] != times_word2[i]){
                System.out.println("N");
                System.exit(0);
            }
        }
        System.out.println("Y");
    }
}
