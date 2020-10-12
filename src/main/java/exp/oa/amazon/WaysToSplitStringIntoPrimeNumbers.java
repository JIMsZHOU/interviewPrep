package exp.oa.amazon;

/**
 * Created by Jim Z on 2020-09-28 17:26
 *
 * TAGS: Amazon, OA, NG, 2020
 *
 * Amazon's operations team needs an algorithm that can break out a list of products for a given order. The products in the order are listed as a string and the order items are represented as prime numbers. Given a string consisting of digits [0-9]. count the number of ways the given string can be split into prime numbers, which represent unique items in the order. The digits must remain in the order given and the entire string must be used.
 *
 * Write ana algorithm to find the number of ways the given string can be split into unique prime numbers using the entire string.
 *
 * INPUT
 * The input to the function/method consists of an argument:
 * inputString, a string representing the input string.
 *
 * OUTPUT
 * Return an integer representing the number of ways the given string can be split into unique primes using the entire string.
 *
 * NOTE
 * The inputString does not contain leading zeros.
 * Each number split of the given number must be in the range 2 to 10^6 inclusive.
 * Since the answer can be large. return the answer module (10000000007)
 *
 * CONSTRAINTS
 * 1 <= length of inputString <= 10 ^5
 *
 * EXAMPLE
 * input:
 * inputString = 11373
 *
 * output:
 * 6
 *
 * explanation:
 * This string can be split into prime numbers in 6 different ways: [11, 3, 7, 3], [113, 7, 3], [11, 3, 73], [11, 37, 3], [113, 73], and [11, 373]
 */
public class WaysToSplitStringIntoPrimeNumbers {

    public int splitToPrimeNumbers(String target) {

        return 0;
    }
}
