package exp.oa.sap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 2020-10-06 17:30
 */
class DivisibleBinaryNumberTest {

    private DivisibleBinaryNumber o = new DivisibleBinaryNumber();

    @Test
    void test1() {
        int ans = o.findDivisibleBNumbers(3, Arrays.asList(new String[]{"100110111", "100111011", "101000001", "1111001", "1100101", "11110"}));
        assertEquals(ans, 3);
    }
}