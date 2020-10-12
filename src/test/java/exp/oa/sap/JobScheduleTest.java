package exp.oa.sap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 2020-10-06 15:36
 */
class JobScheduleTest {

    private JobSchedule o = new JobSchedule();

    @Test
    void test1() {
        int ans = o.jobSchedule(new int[]{6,5,4,3,2,1}, 3);
        System.out.println(ans);
    }

    @Test
    void test2() {
        int ans = o.jobSchedule(new int[]{8,6,2,4,3,1,6,4,3}, 4);
        assertEquals(ans, 15);
    }
}