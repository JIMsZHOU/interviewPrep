package exp.oa.amazon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jim Z on 2020-09-28 17:13
 */
class NearestCityTest {

    private class TestCase {
        int numOfCities;
        List<String> cities;
        List<Integer> xCoordinates;
        List<Integer> yCoordinates;
        int numOfQueries;
        List<String> queries;
        List<String> ans;

        public TestCase(int numOfCities, List<String> cities, List<Integer> xCoordinates, List<Integer> yCoordinates, int numOfQueries, List<String> queries, List<String> ans) {
            this.numOfCities = numOfCities;
            this.cities = cities;
            this.xCoordinates = xCoordinates;
            this.yCoordinates = yCoordinates;
            this.numOfQueries = numOfQueries;
            this.queries = queries;
            this.ans = ans;
        }
    }

    @Test
    void test1() {
        TestCase testCase1 = new TestCase(
                3,
                Arrays.asList(new String[]{"c1", "c2", "c3"}),
                Arrays.asList(new Integer[]{3, 2, 1}),
                Arrays.asList(new Integer[]{3, 2, 3}),
                3,
                Arrays.asList(new String[]{"c1", "c2", "c3"}),
                Arrays.asList(new String[]{"c3", "None", "c1"})
        );

        List<String> ans = new NearestCity().findNearest(
                testCase1.numOfCities,
                testCase1.cities,
                testCase1.xCoordinates,
                testCase1.yCoordinates,
                testCase1.numOfQueries,
                testCase1.queries
        );
        assertArrayEquals(ans.toArray(), testCase1.ans.toArray());
    }
}