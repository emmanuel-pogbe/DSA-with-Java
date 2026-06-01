/*Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
*/
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // first solution
//        int lengthOfInput = nums.length;
//        List<Integer> result = new ArrayList<>();
//        HashMap<Integer,Integer> frequencyCounter = new HashMap<>();
//        for (int i = 0;i<lengthOfInput;i++) {
//            if (!frequencyCounter.containsKey(nums[i])) {
//                frequencyCounter.put(nums[i],1);
//            }
//            else {
//                int currentNumber = frequencyCounter.get(nums[i]);
//                frequencyCounter.replace(nums[i],currentNumber++);
//            }
//        }
//        for (int i = 1;i<=lengthOfInput;i++) {
//            if (!frequencyCounter.containsKey(i)) {
//                result.add(i);
//            }
//        }
//        return result;
// second solution
//        List<Integer> result = new ArrayList<>();
//        int lengthOfInput = nums.length;
//        for (int i = 0;i<lengthOfInput;i++) {
//            boolean found = false;
//            for (int numInput: nums) {
//                if (numInput == i+1) {
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                result.add(i+1);
//            }
//
//        }
//        return result;

        // Third solution
        List<Integer> result = new ArrayList<>();
        int[] resultChecker = new int[nums.length];
        for (int numsInput: nums) {
            resultChecker[numsInput-1] = 1;
        }
        for (int i = 0; i<resultChecker.length;i++) {
            if (resultChecker[i] == 0) {
                result.add(i+1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] test = {1,1};
        System.out.println((findDisappearedNumbers(test).toString()));

    }
}
