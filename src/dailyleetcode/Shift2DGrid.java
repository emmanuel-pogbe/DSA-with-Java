/*Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.
Example 1
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]

Example 2
Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]*/

package dailyleetcode;

import com.sun.jdi.ArrayReference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int maxOfI = grid.length;
        int maxOfJ = grid[0].length;
        int[][] newGrid = new int[maxOfI][maxOfJ];
        for (int i = 0; i<maxOfI; i++) {
            for (int j = 0; j<maxOfJ;j++) {
                int element = grid[i][j];
                int ithPosition = (((j+k)/maxOfJ) + i)%maxOfI;
                int jthPosition = (j+k)%maxOfJ;
                newGrid[ithPosition][jthPosition] = element;
            }
        }
        List<List<Integer>> result= new ArrayList<>();
        for (int i = 0; i<maxOfI;i++) {
            List<Integer> intermediate = new ArrayList<>();
            for (int j = 0; j<maxOfJ;j++) {
                intermediate.add(newGrid[i][j]);
            }
            result.add(intermediate);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[5]};
        int[][] grid2 = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        int k = 4;
        System.out.println(shiftGrid(grid2, k));
    }
}
