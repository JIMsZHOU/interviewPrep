package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 11/4/20 03:32
 */
class LC295_FindMedianFromDataStreamTest {
    LC295_FindMedianFromDataStream o = new LC295_FindMedianFromDataStream();
    @Test
    void test1() {
        o.addNum(12);
        o.addNum(10);
        o.addNum(13);
        o.addNum(11);
        System.out.println(o.findMedian());
    }

}