import java.util.Scanner;

public class ALGO_70 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        String[] words = input.split(" ");

        String longestWord = words[0];
        for (String string : words) {
            if(string.length() > longestWord.length()){
                longestWord = string;
            }
        }
        
        System.out.println(longestWord);
    }
}
