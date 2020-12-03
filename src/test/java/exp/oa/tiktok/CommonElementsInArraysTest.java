package exp.oa.tiktok;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 11/22/20 21:21
 */
class CommonElementsInArraysTest {
    CommonElementsInArrays o = new CommonElementsInArrays();

    @Test
    void test1() {
        int[] ans = o.findCommonElems(
                new int[]{4,9,5,4,8},
                new int[]{9,4,9,8,4}
        );
        System.out.println(Arrays.toString(ans));
    }
}