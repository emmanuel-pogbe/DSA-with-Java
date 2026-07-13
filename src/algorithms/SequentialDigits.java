/*An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.



Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]*/

package algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SequentialDigits {
    public static boolean enumerateDigits(int number, int previous) {
        if (number == 0) {
            return true;
        }
        int remainder = number % 10;
        int wholeNumber = number / 10;
        if (previous - 1 == remainder || previous == -1) {
            boolean valid = enumerateDigits(wholeNumber, remainder);
            if (!valid) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String alpha = "123456789";
        int length_of_alpha = alpha.length();
        int start = 0;
        int step = 1;
        boolean is_boundary_reached = false;
        int x;
        while (step<=9) {
            x = start;
            while ((x + step) <= length_of_alpha) {
                int tested = Integer.parseInt(alpha.substring(x,x+step));
                if (tested > high) {
                    is_boundary_reached = true;
                    break;
                }
                if (tested >= low && tested<=high) {
                    result.add(tested);
                }
                x += 1;
            }
            if (is_boundary_reached) break;
            step+=1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100,Integer.MAX_VALUE));
    }
}
