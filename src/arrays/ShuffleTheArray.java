package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ShuffleTheArray {
    public static int[] shuffleArray(int[] nums, int middle) {
        int[] result = new int[nums.length];
        for (int i = 0; i<middle;i++) {
              result[i*2] = nums[i];
              int newIdx = i + middle;
              result[(i*2)+1] = nums[newIdx];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] test = {2,5,1,3,4,7};
        int[] res = shuffleArray(test,3);
        for (int ac: res) {
            System.out.print(ac+" ");
        }

    }
}
