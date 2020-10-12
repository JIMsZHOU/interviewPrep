package exp.oa.sap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 2020-10-05 18:07
 */
class IncreasingDigitsTest {

    private IncreasingDigits o = new IncreasingDigits();

    private class TestCase {
        int input;
        int ans;

        public TestCase(int input, int ans) {
            this.input = input;
            this.ans = ans;
        }
    }

    @Test
    void test1() {
        TestCase testCase = new TestCase(1234, 1234);
        int ans = o.monaPeculiarNumber(testCase.input);
        assertEquals(ans, testCase.ans);
    }

    @Test
    void test2() {
        TestCase testCase = new TestCase(998, 789);
        int ans = o.monaPeculiarNumber(testCase.input);
        assertEquals(ans, testCase.ans);
    }

    @Test
    void test3() {
        TestCase testCase = new TestCase(0, 0);
        int ans = o.monaPeculiarNumber(testCase.input);
        assertEquals(ans, testCase.ans);
    }

    @Test
    void test4() {
        TestCase testCase = new TestCase(9876, 6789);
        int ans = o.monaPeculiarNumber(testCase.input);
        assertEquals(ans, testCase.ans);
    }

    @Test
    void test5() {
        TestCase testCase = new TestCase(1000, 789);
        int ans = o.monaPeculiarNumber(testCase.input);
        assertEquals(ans, testCase.ans);
    }
}