import java.util.Scanner;
import java.util.Stack;

public class ALGO_156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String suffix = toSuffixStatement(line);
        //System.out.println(suffix);

        Stack<Integer> stack = new Stack<>();

        String[] operands = suffix.split(" ");
        for (String c : operands) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                // System.out.println("" + operand1 + c + operand2);

                switch (c) {
                case "*":
                    stack.push(operand1 * operand2);
                    break;
                case "/":
                    stack.push(operand1 / operand2);
                    break;
                case "+":
                    stack.push(operand1 + operand2);
                    break;
                case "-":
                    stack.push(operand1 - operand2);
                    break;
                default:
                    break;
                }
                // System.out.println(stack.peek());
            } else {
                int num = Integer.parseInt(c);
                stack.push(num);
            }
        }

        int result = stack.pop();
        System.out.println(result);

    }

    public static String toSuffixStatement(String string) {
        StringBuffer buffer = new StringBuffer();
        Stack<Character> stack = new Stack<>();

        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                    num *= 10;
                    num += (chars[i + 1] - '0');
                    i++;
                }

                buffer.append(num);
                buffer.append(" ");
            } else {
                if (c == ')') {
                    while (!stack.isEmpty()) {
                        char curOper = stack.pop();
                        if (curOper != '(') {
                            buffer.append(curOper);
                            buffer.append(" ");
                        } else {
                            break;
                        }

                    }
                    continue;
                }

                while (!stack.isEmpty() && !isLargerThan(c, stack.peek())) {
                    char curOper = stack.pop();
                    buffer.append(curOper);
                    buffer.append(" ");
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            buffer.append(stack.pop());
            buffer.append(" ");
        }

        return buffer.toString();
    }

    public static boolean isLargerThan(char operator1, char operator2) {
        if (operator1 == '(' || operator2 == '(') {
            return true;
        }
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
            return true;
        }
        return false;
    }
}
