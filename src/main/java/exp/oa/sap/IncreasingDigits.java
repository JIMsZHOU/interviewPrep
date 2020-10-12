package exp.oa.sap;

/**
 * Created by Jim Z on 2020-10-05 14:00
 *
 * TAGS: SAP, SVNT, OA, NG, 2020
 *
 * John has a fascination with numbers. He likes numbers that have their digits in increasing order like 149, 468, 789, etc. He does not like numbers that don't follow this rule like 543, 664, 299, etc.
 *
 * Given a number N as input, find the largest number less than or equal to N which will appeal to John's liking.
 *
 * Input
 *
 * An integer N which is less than 1,000,000.
 *
 * Output
 *
 * An integer less than or equal to N, which appeals to John's peculiar rules.
 *
 * For example:
 *
 * If the input number is 1234 then this number already has its digits in increasing order, and hence, the output would be the same number i.e. 1234.
 *
 * If the input number is 998 then this number doesn’t have its digits in increasing order and we will decrement this number by 1 in each iteration till we reach the number 789 which follows the desired order.
 */
public class IncreasingDigits {
    public int monaPeculiarNumber(int num) {
        char[] ans = Integer.toString(num).toCharArray();
        int l = ans.length -2;
        int r = ans.length -1;

        while (l >= 0) {
            // check if two number violet the rules, we decrease left number by 1 and set the right number to 9 (the max of single digit)
            if (ans[l] - '0' >= ans[r] - '0') {
                ans[l] -= 1;
                ans[r] = '9';
            }

            // if after first check, the right digit and right + 1 digits violet the rules. we need to increase the index to do violation again
            if (r != ans.length - 1 && ans[r] - '0' >= ans[r+1] - '0') {
                l++;
                r++;
            } else { // if two digits follow the rules, then we can move index leftwards
                l--;
                r--;
            }
        }

        return Integer.parseInt(String.valueOf(ans));
    }
}
