/**You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

 Evaluate the expression. Return an integer that represents the value of the expression.

 Note that:

 The valid operators are '+', '-', '*', and '/'.
 Each operand may be an integer or another expression.
 The division between two integers always truncates toward zero.
 There will not be any division by zero.
 The input represents a valid arithmetic expression in a reverse polish notation.
 The answer and all the intermediate calculations can be represented in a 32-bit integer.


 Example 1:

 Input: tokens = ["2","1","+","3","*"]
 Output: 9
 Explanation: ((2 + 1) * 3) = 9*/

package stack;

import java.util.ArrayList;
import java.util.List;

public class EvaluateReversePolishNotation {
    public static int performOperation(int operand1, int operand2, String operator) {
        if (operator.equals("+")) return operand1 + operand2;
        if (operator.equals("-")) return operand1 - operand2;
        if (operator.equals("*")) return operand1 * operand2;
        if (operator.equals("/")) {
            if (operand2 == 0) throw new ArithmeticException("Can't divide by 0");
            return operand1 / operand2;
        }
        throw new IllegalArgumentException("Operator not recognized");
    }
    public static int evalRPN(String[] tokens) {
        List<Integer> operands = new ArrayList<>();
        for (String character: tokens) {
            try {
                operands.add(Integer.parseInt(character));
            } catch (NumberFormatException e) {
                int operand2 = operands.removeLast();
                int operand1 = operands.removeLast();
                operands.add(performOperation(operand1, operand2, character));
            }
        }
        return operands.getLast();
    }

    public static void main(String[] args) {
        String[] tokens ={ "10","6","9","3","+","-11","*","/","*","17","+","5","+"  };
        System.out.println(evalRPN(tokens));
    }
}
