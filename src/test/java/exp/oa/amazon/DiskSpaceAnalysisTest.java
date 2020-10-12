package exp.oa.amazon;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 2020-09-25 14:00
 */
class DiskSpaceAnalysisTest {

    private class TestCase {
        int numComputer;
        List<Integer> hardDiskSpace;
        int segmentLength;
        int ans;

        public TestCase(int numComputer, Integer[] hardDiskSpace, int segmentLength, int ans) {
            this.numComputer = numComputer;
            this.hardDiskSpace = Arrays.asList(hardDiskSpace);
            this.segmentLength = segmentLength;
            this.ans = ans;
        }
    }

    @Test
    void test1() {
        TestCase testCase1 = new TestCase(3, new Integer[]{8, 2, 4}, 2, 2);
        int ans = new DiskSpaceAnalysis().maxOfSegment(testCase1.numComputer, testCase1.hardDiskSpace, testCase1.segmentLength);
        assertEquals(ans, testCase1.ans);
    }
}