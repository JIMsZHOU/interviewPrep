package exp.oa.tigergraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 11/4/20 15:00
 */
class LC480_SlidingWindowMedianTest {
    LC480_SlidingWindowMedian o = new LC480_SlidingWindowMedian();

    @Test
    void test1() {
        double[] ans = o.twoPriorityQueues(new int[]{
                -2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648
        }, 3);
        System.out.println(ans);
    }

}