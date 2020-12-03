package exp.oa.tigergraph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 11/9/20 15:55
 */
class UniversityCareerFairTest {
    UniversityCareerFair o = new UniversityCareerFair();

    @Test
    void test1() {
        List<Integer> arr = Arrays.asList(0, 0, 1, 2, 3, 4, 4, 5);
        List<Integer> dur = Arrays.asList(3, 1, 2, 2, 1, 1, 8, 4);
        int res = o.maxEvents(arr, dur);
        assertEquals(res, 5);
    }

}