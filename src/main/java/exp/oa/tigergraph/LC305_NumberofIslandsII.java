package exp.oa.tigergraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jim Z on 11/5/20 23:50
 *
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example:
 *
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 *
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 *
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 *
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 *
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * Follow up:
 *
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class LC305_NumberofIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        if (m <= 0 || n <= 0) return ans;

        int cnt = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[] uf = new int[m * n + 1]; // since init will 0 so we increase 1 size bigger, to make 0 represent water

        for (int[] p : positions) {
            int island = n * p[0] + p[1] + 1; // use positions[0].length * x + y + 1 to represent the key of that position
            if (uf[island] != 0) {
                // if the island is created before
                ans.add(cnt);
                continue;
            }
            uf[island] = island;
            cnt++; // assume this position becomes a new island

            // then search four directions to see whether connect to another island, union found island and decrease the counter
            for (int[] direct : directions) {
                int x = p[0] + direct[0];
                int y = p[1] + direct[1];
                int fIsland = n * x + y + 1; // island to find
                if (x < 0 || x >= m || y < 0 || y >= n || uf[fIsland] == 0) {
                    continue;
                } else { // is an island
                    int parentOfFIsland = quickFind(uf, fIsland);
                    // quick union them together
                    if (island != parentOfFIsland) {
                        uf[island] = parentOfFIsland;
                        island = parentOfFIsland;
                        cnt--;
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    private int quickFind(int[] uf, int id) {
        while (id != uf[id]) {
            uf[id] = uf[uf[id]]; // this enable path compression
            id = uf[id];
        }
        return id;
    }
}
