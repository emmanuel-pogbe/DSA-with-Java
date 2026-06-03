/*You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.*/

package algorithms;

public class FirstBadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public static boolean isBadVersion(int n) {
        if (n==1) return true;
        return n >= 4;
    }
    public static int firstBadVersion(int n) {
            int mid;
            int left = 1;
            int right = n;
            int lastBadVersion = -1;
            while (left<=right) {
                mid = left + (right-left)/2;
                if (isBadVersion(mid)) {
                    right = mid-1;
                    lastBadVersion = mid;
                }
                else {
                    left = mid+1;
                }
            }
            return lastBadVersion;
    }
    public static int firstBadVersionBad(int n) {
        for (int i = 1;i <= n; i++ ) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return -1;
     }
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2));
    }
}
