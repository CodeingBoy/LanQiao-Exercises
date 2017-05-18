import java.util.Scanner;

public class ALGO_84 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        char[] chars = word.toCharArray();

        StringBuffer buffer = new StringBuffer();
        for (char c : chars) {
            if(Character.isUpperCase(c)){
                buffer.append(Character.toLowerCase(c));
            }else{
                buffer.append(Character.toUpperCase(c));
            }
        }
        System.out.println(buffer);
    }
}
