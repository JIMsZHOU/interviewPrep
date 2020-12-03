package exp.oa.tiktok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 11/22/20 16:53
 */
class SelectPairsTest {
    SelectPairs o = new SelectPairs();

    @Test
    void test1() {
        int ans = o.smallestLeft(6, new int[]{2, 7, 4, 1, 8, 1});
        System.out.println(ans);
    }
}