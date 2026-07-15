package algorithms;
/*Euclidean algorithm is based on the fact that H.C.F/GCD of two numbers divides
* their difference as well
*
* If we subtract a smaller number from a larger one (we reduce a larger number), GCD doesn't change. So if we keep subtracting repeatedly the larger of two, we end up with GCD.
Now instead of subtraction, if we divide the larger number, the algorithm stops when we find the remainder 0.

* */
public class EuclideanAlgorithm {
    public static int calculateGcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b%a;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(calculateGcd(45,15));
    }
}
