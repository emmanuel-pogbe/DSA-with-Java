/*
Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.



Example 1:

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]/
 */
package arrays;

import java.util.Arrays;

public class DuplicateZeros {
    public static void insertZeroAfterIndex(int index,int[] arr) {
        int lastIndex = arr.length - 1;
        for (int i = lastIndex-1; i>=index; i-- ) {
            arr[i+1] = arr[i];
        }
        arr[index] = 0;
    }
    public static void duplicateZeros(int[] arr) {
        int  lengthOfArray = arr.length;
        for (int i = 0; i<lengthOfArray-1;i++) {
            if (arr[i] == 0) {
                insertZeroAfterIndex(i+1,arr);
                i = i+1;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0};
        int[] arr2 = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
