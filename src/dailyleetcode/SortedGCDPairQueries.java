/*You are given an integer array nums of length n and an integer array queries.

Let gcdPairs denote an array obtained by calculating the GCD of all possible pairs (nums[i], nums[j]), where 0 <= i < j < n, and then sorting these values in ascending order.

For each query queries[i], you need to find the element at index queries[i] in gcdPairs.

Return an integer array answer, where answer[i] is the value at gcdPairs[queries[i]] for each query.

The term gcd(a, b) denotes the greatest common divisor of a and b.



Example 1:

Input: nums = [2,3,4], queries = [0,2,2]

Output: [1,2,2]

Explanation:

gcdPairs = [gcd(nums[0], nums[1]), gcd(nums[0], nums[2]), gcd(nums[1], nums[2])] = [1, 2, 1].

After sorting in ascending order, gcdPairs = [1, 1, 2].

So, the answer is [gcdPairs[queries[0]], gcdPairs[queries[1]], gcdPairs[queries[2]]] = [1, 2, 2].

Example 2:

Input: nums = [4,4,2,1], queries = [5,3,1,0]

Output: [4,2,1,1]

Explanation:

gcdPairs sorted in ascending order is [1, 1, 1, 2, 2, 4].

Example 3:

Input: nums = [2,2], queries = [0,0]

Output: [2,2]

Explanation:

gcdPairs = [2].*/

package dailyleetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortedGCDPairQueries {

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a,a);
    }
    public static int[] gcdValues(int[] nums, long[] queries) {

        // Find the largest number
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Count occurrences of each value
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }

        // divisibleCount[g] = how many numbers are divisible by g
        int[] divisibleCount = new int[max + 1];
        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                divisibleCount[g] += count[multiple];
            }
        }

        // pairCount[g] = pairs where both numbers are divisible by g
        long[] pairCount = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            long c = divisibleCount[g];
            pairCount[g] = c * (c - 1) / 2;
        }

        // exact[g] = pairs whose gcd is exactly g
        long[] exact = new long[max + 1];
        for (int g = max; g >= 1; g--) {

            exact[g] = pairCount[g];

            for (int multiple = g * 2; multiple <= max; multiple += g) {
                exact[g] -= exact[multiple];
            }
        }

        // Prefix sums
        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }

        // Answer queries
        int[] answers = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long q = queries[i] + 1; // queries are 0-indexed

            int left = 1;
            int right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= q) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            answers[i] = left;
        }

        return answers;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4};
        int[] nums2 = {4,4,2,1};
        long[] queries = {0,2,2};
        long[] queries2 = {5,3,1,0};

        System.out.println(Arrays.toString(gcdValues(nums2,queries2)));
    }
}
