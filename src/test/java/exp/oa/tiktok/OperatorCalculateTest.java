package exp.oa.tiktok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 11/22/20 16:24
 */
class OperatorCalculateTest {
    private OperatorCalculate o = new OperatorCalculate();

    @Test
    void test1() {
        int ans = o.calculate("(3#2)@(1!2)");
        System.out.println(ans);
    }
}