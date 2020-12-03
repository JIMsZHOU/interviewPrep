package exp.oa.tiktok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 11/22/20 14:21
 */
class MaxGlodPathTest {

    private MaxGlodPath o = new MaxGlodPath();

    @Test
    void test1() {
        int[][] grid = {
                {1, 2, 1},
                {2, 0, 1},
                {1, 0, 2},
                {1, 1, 1}
        };
//        int[][] grid = {
//                {1, 2},
//                {1, 1}
//        };
        int ans = o.FindmaxPath(grid, 5);
        System.out.println(ans);
    }
}