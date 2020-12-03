package exp.oa.tiktok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 11/22/20 17:17
 */
class NumberOfBytedanceTest {
    NumberOfBytedance o = new NumberOfBytedance();

    @Test
    void test1() {
        String s = "decdefgesanbwerhgcytec";
        int ans = o.countNumOfBytedance(s);
        System.out.println("1:"+ans);
    }

    @Test
    void test2() {
        String s = "bytedanwwwercebytexxxcvdance";
        int ans = o.countNumOfBytedance(s);
        System.out.println("2:"+ans);
    }

    @Test
    void test3() {
        String s = "google";
        int ans = o.countNumOfBytedance(s);
        System.out.println("3:"+ans);
    }

}