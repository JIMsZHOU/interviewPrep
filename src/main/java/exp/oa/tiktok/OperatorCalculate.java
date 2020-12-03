package exp.oa.tiktok;

import java.util.Stack;

/**
 * Created by Jim Z on 11/22/20 14:58
 */
public class OperatorCalculate {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = 0;

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = c - '0';
                // give whole number
                while (i < s.length() -1 && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(num);
                num = 0; // reset number
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if (c == '!' || c == '@' || c == '#' || c == '$') {
                while (!ops.isEmpty() && precedence(c, ops.peek())) {
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private int operation(char op, int b, int a) {
        switch (op) {
            case '!': return (b - a) % 10007;
            case '@': return (a + b) % 10007;
            case '#': return (a * a * b) % 10007;
            case '$': return (a * b * b) % 10007;
        }
        return 0;
    }

    private boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ( (op1 == '#' || op1 == '$') && (op2 == '!' || op2 == '@') ) {
            return false;
        }
        return true;
    }

}
