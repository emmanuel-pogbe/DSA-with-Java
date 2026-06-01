/*
* Given a binary array nums, return the maximum number of consecutive 1's in the array.
* */

package arrays;

import java.util.Arrays;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int oneCounter = 0;
        int maxOnes = 0;
        for (int num: nums) {
            if (num == 1) {
                oneCounter++;
            } else {
                if (oneCounter>maxOnes) {
                    maxOnes = oneCounter;
                }
                oneCounter = 0;
            }
        }
        maxOnes = Math.max(maxOnes, oneCounter);
        return maxOnes;
    }
    public static void main(String[] args) {
        int[] test = {0,1,0,1,0,1};
        System.out.println(findMaxConsecutiveOnes(test));

    }
}
