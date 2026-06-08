/*Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4*/

package algorithms;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int lengthOfInput = nums.length;
        int left = 0;
        int right = lengthOfInput-1;
        while (left<=right) {
            int middle = left + ((right - left)/2);
            int mid = nums[middle];
            if (mid == target) {
                return middle;
            }
            if (mid < target) {
                left = middle + 1;
            }
            if (mid > target) {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int target2 = 2;
        System.out.println(search(nums, target));
        System.out.println(search(nums, target2));

    }
}
