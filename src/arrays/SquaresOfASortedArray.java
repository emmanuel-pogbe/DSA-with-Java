/*Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]*/
package arrays;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static int[] sortedSquares(int[] nums) {
        int counter = nums.length - 1;
        int[] result = new int[nums.length];
        int startIdx = 0;
        int startNumber;
        int endNumber;
        int endIdx = nums.length - 1;
        while (counter>=0) {
            startNumber = Math.abs(nums[startIdx]);
            endNumber = Math.abs(nums[endIdx]);
            if (endNumber > startNumber) {
                endNumber = endNumber * endNumber;
                result[counter] = endNumber;
                endIdx--;
            }
            else if (startNumber >= endNumber) {
                startNumber = startNumber* startNumber;
                result[counter] = startNumber;
                startIdx++;
            }
            counter--;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] test = {2,3,11};
        System.out.println(Arrays.toString(sortedSquares(test)));

    }
}
