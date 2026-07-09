/*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.*/

package arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tracker = nums1.length - 1;
        while (m >0 || n > 0) {
            int leftSide = 0; // left side represents number gotten from nums1
            int rightSide = 0; // right side represents number gotten from nums;
            if (n != 0) {
                rightSide = nums2[n-1];
            } else {
                rightSide = Integer.MIN_VALUE;
            }
            if (m!=0){
                leftSide = nums1[m-1];
            } else {
                leftSide = Integer.MIN_VALUE;
            }
            if (leftSide >= rightSide) {
                nums1[tracker] = leftSide;
                m--;
            } else {
                nums1[tracker] = rightSide;
                n--;
            }
            tracker--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        merge(nums1, 1, nums2, 0);
    }
}
