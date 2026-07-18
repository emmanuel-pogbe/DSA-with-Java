/*
* Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.



Example 1:

Input: nums = [2,5,6,9,10]
Output: 2
Explanation:
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.
Example 2:

Input: nums = [7,5,6,8,3]
Output: 1
Explanation:
The smallest number in nums is 3.
The largest number in nums is 8.
The greatest common divisor of 3 and 8 is 1.
Example 3:

Input: nums = [3,3]
Output: 3
Explanation:
The smallest number in nums is 3.
The largest number in nums is 3.
The greatest common divisor of 3 and 3 is 3.


Constraints:

2 <= nums.length <= 1000
1 <= nums[i] <= 1000*/

package dailyleetcode;

import java.util.Arrays;
import java.util.OptionalInt;

public class GreatestCommonDivisorOfArray {
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a,a);
    }
// I accidentally solved the wrong problem because I didn't read through the question properly :(
//    public static int findGCD(int[] nums) {
//        if (nums.length == 2) {
//            return gcd(nums[0], nums[1]);
//        }
//        int[] intermediate = new int[nums.length-1];
//        System.arraycopy(nums,1,intermediate,0,nums.length-1);
//        return gcd(nums[0], findGCD(intermediate));
//    }
    public static int findGCD(int[] nums) {
//        int maxNo = nums[0], minNo = nums[0];
        int maxNo= Arrays.stream(nums).max().getAsInt();
        int minNo = Arrays.stream(nums).min().getAsInt();
        for (int i = 1; i <  nums.length; i++) {
            int numberInQuestion = nums[i];
            if (numberInQuestion > maxNo) {
                maxNo = numberInQuestion;
            }
            if (numberInQuestion < minNo) {
                minNo = numberInQuestion;
            }
        }
        return gcd(maxNo, minNo);
    }
    public static void main(String[] args) {
        int[] nums = {2,5,6,9,10};
        int[] num2 = {10,6,9};
        System.out.println(findGCD(num2));
        System.out.println(gcd(10,6));
    }
}
