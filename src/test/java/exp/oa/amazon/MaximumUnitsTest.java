package exp.oa.amazon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jim Z on 2020-09-24 17:41
 */
class MaximumUnitsTest {

    private class TestCase {
        int num;
        List<Integer> boxes;
        int unitSize;
        List<Integer> unitsPerBox;
        int truckSize;
        int ans;

        public TestCase(int num, Integer[] boxes, int unitSize, Integer[] unitsPerBox, int truckSize, int ans) {
            this.num = num;
            this.boxes = Arrays.asList(boxes);
            this.unitSize = unitSize;
            this.unitsPerBox = Arrays.asList(unitsPerBox);
            this.truckSize = truckSize;
            this.ans = ans;
        }
    }

    @Test
    void test1() {
        TestCase testCase1 = new TestCase(3, new Integer[]{1, 2, 3}, 3, new Integer[]{3,2,1}, 3, 7);
        int ans = new MaximumUnits().calTheMax(testCase1.num, testCase1.boxes, testCase1.unitSize, testCase1.unitsPerBox, testCase1.truckSize);
        System.out.println(ans);
        assertEquals(ans, testCase1.ans);
    }

    @Test
    void test2() {
        TestCase testCase2 = new TestCase(3, new Integer[]{1, 2, 3}, 3, new Integer[]{3,2,1}, 6, 10);
        int ans = new MaximumUnits().calTheMax(testCase2.num, testCase2.boxes, testCase2.unitSize, testCase2.unitsPerBox, testCase2.truckSize);
        System.out.println(ans);
        assertEquals(ans, testCase2.ans);
    }

    @Test
    void test3() {
        TestCase testCase3 = new TestCase(3, new Integer[]{4, 5, 1}, 3, new Integer[]{1,2,5}, 2, 5+2);
        int ans = new MaximumUnits().calTheMax(testCase3.num, testCase3.boxes, testCase3.unitSize, testCase3.unitsPerBox, testCase3.truckSize);
        System.out.println(ans);
        assertEquals(ans, testCase3.ans);
    }

    @Test
    void test4() {
        TestCase testCase4 = new TestCase(3, new Integer[]{4, 5, 1}, 3, new Integer[]{1,2,5}, 6, 5+10);
        int ans = new MaximumUnits().calTheMax(testCase4.num, testCase4.boxes, testCase4.unitSize, testCase4.unitsPerBox, testCase4.truckSize);
        System.out.println(ans);
        assertEquals(ans, testCase4.ans);
    }
}