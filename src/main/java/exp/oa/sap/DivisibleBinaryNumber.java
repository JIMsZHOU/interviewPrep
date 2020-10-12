package exp.oa.sap;

import java.util.List;

/**
 * Created by Jim Z on 2020-10-06 17:15
 *
 * TAGS: SAP SVNT NG OA 2020
 *
 * From a comma-separated list of binary numbers, find how many numbers are divisible by a given number x.
 * x is an integer in the range 1 to 9 and the total count of the binary numbers in the list will be less than 1000.
 *
 * You're allowed to create new functions.
 *
 * Input:
 *
 * x
 * <binary numbers>,.....,n
 *
 * Output:
 * <count>
 *
 * Example:
 *
 * input:
 * 3
 * 100110111, 100111011,101000001,1111001,1100101,11110
 *
 * Output:
 * 4
 *
 */
public class DivisibleBinaryNumber {

    public int findDivisibleBNumbers(int x, List<String> binaries) {
        int count = 0;
        for (String binary : binaries) {
            if (covertInteger(binary) % x == 0) {
                count++;
            }
        }
        return count;
    }

    private int covertInteger(String binary) {
        return Integer.parseInt(binary,2);
    }
}
