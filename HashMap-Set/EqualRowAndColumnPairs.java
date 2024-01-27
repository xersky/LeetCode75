/* Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [
    [3,1,2,2],
    [1,4,4,5],
    [2,4,2,2],
    [2,4,2,2]
]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualRowAndColumnPairs {
    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        int counter = 0 ;

        List<int[]> columns = new ArrayList<int[]>();
        List<int[]> rows = new ArrayList<int[]>();

        for(int i = 0; i < n; i++) {
            int[] column = new int[n];
            for(int j = 0; j < n; j++) {
                column[j] = grid[j][i];
            }
            columns.add(column);
            rows.add(grid[i]);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(Arrays.equals(rows.get(i), columns.get(j))) counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(equalPairs(grid));
    }
}
