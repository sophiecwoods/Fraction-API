package fraction;

import static org.junit.Assert.*;
import org.junit.*;

public class FractionImplTest {

    @Test
    public void testGreatestCommonDivisor() {

        int[] nums1 = { 1, 1, 3, 4,  5, 124, 13, 0, 0,  -50, 66, 192_000, 1_983_204_571, -2_147_483_646 };
        int[] nums2 = { 1, 2, 3, 2, 10,  16, 99, 7, 0, -100, -6, 270_000, 2_147_483_647, -2_138_951_326 };
        int[] GCD = {   1, 1, 3, 2,  5,   4,  1, 7, 0,   50,  6,   6_000,             1,              2 };

        for (int i = 0; i < nums1.length; i++) {
            long result = FractionImpl.greatestCommonDivisor(nums1[i], nums2[i]);
            assertEquals(result, GCD[i]);
        }
    }

    @Test
    public void testNormaliseFraction() {
        int[] numeratorIn = {    0, 1, 5,  6,  8,  125, -20, -33,   -999_999_999,      1_000_000, -832_457_592 };
        int[] denominatorIn = {  1, 2, 1, -1, -4, -489, -50, 100, -1_234_567_890, -2_147_483_646,            3 };

        int[] numeratorOut = {   0, 1, 5, -6, -8, -125,  20, -33,    999_999_999,     -1_000_000,  -832_457_592 };
        int[] denominatorOut = { 1, 2, 1,  1,  4,  489,  50, 100,  1_234_567_890,  2_147_483_646,            3 };

        for (int i = 0; i < numeratorIn.length; i++) {
            int[] results = FractionImpl.normaliseFraction(numeratorIn[i], denominatorIn[i]);
            assertEquals(results[0], numeratorOut[i]);
            assertEquals(results[1], denominatorOut[i]);
        }
    }


    @Test
    public void testAdd() {
        int[] firstNumerator = {    1, 1,  2,    50,  3,   300, 20,    6,        29_456,    998 };
        //
        int[] firstDenominator = {  2, 1,  1,   100,  8, 6_000, 50,   24,        53_317,    999 };
        //

        int[] secondNumerator = {   1, 3,  4,   999, -6,     1, 30, -100,         7_803,     5 };
        //
        int[] secondDenominator = { 2, 4,  5, 7_000,  8, 6_000, 50,  400,        38_290,     1 };
        //

        int[] resultNumerator = {   1, 7, 14,  4_499, -3,   301,  1,    0, 1_543_902_791, 5_993 };
        //
        int[] resultDenominator = { 1, 4,  5,  7_000,  8, 6_000,  1,    1, 2_041_507_930,   999 };
        //

        for (int i = 0; i < firstNumerator.length; i++) {
            Fraction f1 = new FractionImpl(firstNumerator[i], firstDenominator[i]);
            Fraction f2 = new FractionImpl(secondNumerator[i], secondDenominator[i]);
            Fraction r = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(f1.add(f2), r);
        }
    }
}


