package exp.oa.tiktok;

/**
 * Created by Jim Z on 11/20/20 13:56
 *
 * Given an mxn grid of 0s,1s and 2s (0 denoting an obstacle, 1 denoting empty cell and 2 denoting cell with gold). Find the path used to reach from (0,0) to (m - 1, n - 1) collecting maximum gold if you are allowed to travel in any four directions and can take a maximum of k steps.
 */
public class MaxGlodPath {
    // TODO:
    public int FindmaxPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 0 || grid[m-1][n-1] == 0 || k < m+n-2) {
            return 0;
        }
        int maxGold = 0;
        maxGold = getMaxGold(grid, m, n, 0, 0, k);
        return maxGold;
    }

    private int getMaxGold(int[][] grid, int m, int n, int r, int c, int k) {
        if (r < 0 || r >= m || c < 0 || c >= n || k < 0 || grid[r][c] == 0) {
            return -1;
        }

        if (r == m -1 && c == n -1) {
            return grid[r][c] - 1;
        }
        int origin = grid[r][c];
        grid[r][c] = 0;
        int maxGold = 0;
        int[] subsum = new int[4];
        subsum[0] = getMaxGold(grid, m, n, r, c-1, k -1);
        subsum[1] = getMaxGold(grid, m, n, r, c+1, k -1);
        subsum[2] = getMaxGold(grid, m, n, r+1, c, k -1);
        subsum[3] = getMaxGold(grid, m, n, r-1, c, k -1);
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if (subsum[i] != -1) {
                maxGold = Math.max(maxGold, subsum[i]);
                flag = true;
            }
        }
        grid[r][c] = origin;
        return flag ? maxGold + origin - 1 : -1;
    }

}
