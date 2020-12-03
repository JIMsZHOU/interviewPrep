package exp.oa.tigergraph;

import java.util.*;

/**
 * Created by Jim Z on 11/5/20 19:45
 *
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class LC200_NumberofIslands {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        if (grid.length == 0) return cnt;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    cleanIsland(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void cleanIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // clean this island to water
        grid[i][j] = '0';
        cleanIsland(grid, i-1, j);
        cleanIsland(grid, i+1, j);
        cleanIsland(grid, i, j-1);
        cleanIsland(grid, i, j+1);
    }
}
