package arrays;

import java.util.Arrays;

public class ConcatenationOfArray {
    public static int[] concatenateArray(int[] sample) {
        int resultSize = sample.length * 2;
        int[] resultOfConcatenation = new int[resultSize];
        for (int i = 0; i<resultOfConcatenation.length;i++) {
            resultOfConcatenation[i] = sample[i%sample.length];
        }
        return resultOfConcatenation;
    }

    public static void main(String[] args) {
        int[] x = {1,2,1};
        System.out.println(Arrays.toString(concatenateArray(x)));

    }

}
