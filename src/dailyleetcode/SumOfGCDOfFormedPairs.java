/*You are given an integer array nums of length n.

Construct an array prefixGcd where for each index i:

Let mxi = max(nums[0], nums[1], ..., nums[i]).
prefixGcd[i] = gcd(nums[i], mxi).
After constructing prefixGcd:

Sort prefixGcd in non-decreasing order.
Form pairs by taking the smallest unpaired element and the largest unpaired element.
Repeat this process until no more pairs can be formed.
For each formed pair, compute the gcd of the two elements.
If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.
Return an integer denoting the sum of the GCD values of all formed pairs.

The term gcd(a, b) denotes the greatest common divisor of a and b.*/

package dailyleetcode;

import java.util.Arrays;

public class SumOfGCDOfFormedPairs {
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static long gcdSum(int[] nums) {
        int numsLength = nums.length;
        int[] prefixGcd = new int[numsLength];
        int maxI = nums[0]; // 3,6,2,8
        prefixGcd[0] = nums[0];
        for (int i = 1;i<numsLength; i++) {
            if (nums[i]>=maxI) {
                prefixGcd[i] = nums[i];
                maxI = nums[i];
            } else {
                prefixGcd[i] = gcd(nums[i],maxI);
            }
        }
        Arrays.sort(prefixGcd);

        long sumOfGcds = 0;
        int middle = numsLength/2;
        for (int i = 0;i < middle; i++) {
            int left = prefixGcd[i];
            int right = prefixGcd[numsLength-1-i];
            sumOfGcds += gcd(left,right);
        }
        return sumOfGcds;
    }
    public static void main(String[] args) {
        int[] x = {2,6,4};
        long res = gcdSum(x);
        System.out.println(res);
    }
}
