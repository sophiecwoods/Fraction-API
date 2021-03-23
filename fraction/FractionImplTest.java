package fraction;

import static org.junit.Assert.*;
import org.junit.*;

public class FractionImplTest {

    @Test
    public void testNumeratorDenominatorConstructor() {

        int[] nums1 = {       1,  4, 7, -12, -300,    708,  -200_000, 0, 64_389, -1_000_000 };
        int[] nums2 = {       6, 30, 1, -13,  500, -4_513, 7_000_000, 1,    123,  9_999_999 };

        int[] numerator = {   1,  2, 7,  12,   -3,   -708,        -1, 0, 64_389, -1_000_000 };
        int[] denominator = { 6, 15, 1,  13,    5,  4_513,        35, 1,    123,  9_999_999 };

        for (int i = 0; i < nums1.length; i++) {
            Fraction input = new FractionImpl(nums1[i], nums2[i]);
            Fraction result = new FractionImpl(numerator[i], denominator[i]);
            assertEquals(input, result);

        }
    }


    @Test(expected = ArithmeticException.class)
    public void testZeroDenominator() {
        Fraction f = new FractionImpl(1, 0);
    }


    @Test
    public void testWholeNumberConstructor() {

        int[] wholeNum = {    3, 65, 27_604, 123_456_789, 2_147_483_647, -50, -71_452, -2_147_483_647, 0, 1 };
        int[] numerator = {   3, 65, 27_604, 123_456_789, 2_147_483_647, -50, -71_452, -2_147_483_647, 0, 1 };
        int[] denominator = { 1,  1,      1,           1,             1,   1,       1,              1, 1, 1 };

        for (int i = 0; i < wholeNum.length; i++) {
            Fraction input = new FractionImpl(wholeNum[i]);
            Fraction result = new FractionImpl(numerator[i], denominator[i]);
            assertEquals(input, result);
        }
    }


    @Test
    public void testStringConstructor() {

        String[] str =    {  "1", "-8", "-36490", "9356771", "0", "22/45", "30 / 90", "-100 /650", "-2/ -17", "5/1" };
        int[] numerator = {   1,   -8,  -36_490,  9_356_771,  0,      22,         1,         -10,         2,     5 };
        int[] denominator = { 1,    1,        1,          1,  1,      45,         3,          65,        17,     1 };

        for (int i = 0; i < str.length; i++) {
            Fraction input = new FractionImpl(str[i]);
            Fraction result = new FractionImpl(numerator[i], denominator[i]);
            assertEquals(input, result);
        }

    }


    @Test(expected = NumberFormatException.class)
    public void testIllegalString() {
        Fraction f = new FractionImpl("a");
    }


    @Test
    public void testGreatestCommonDivisor() {

        int[] nums1 = { 1, 1, 3, 4,  5, 124, 13, 0, 0,  -50, 66, 192_000, 1_983_204_571, -2_147_483_646 };
        int[] nums2 = { 1, 2, 3, 2, 10,  16, 99, 7, 0, -100, -6, 270_000, 2_147_483_647, -2_138_951_326 };
        int[] GCD = {   1, 1, 3, 2,  5,   4,  1, 7, 0,   50,  6,   6_000,             1,              2 };

        for (int i = 0; i < nums1.length; i++) {
            int result = FractionImpl.greatestCommonDivisor(nums1[i], nums2[i]);
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
        int[] firstDenominator = {  2, 1,  1,   100,  8, 6_000, 50,   24,        53_317,    999 };

        int[] secondNumerator = {   1, 3,  4,   999, -6,     1, 30, -100,         7_803,     5 };
        int[] secondDenominator = { 2, 4,  5, 7_000,  8, 6_000, 50,  400,        38_290,     1 };

        int[] resultNumerator = {   1, 7, 14,  4_499, -3,   301, 1,    0, 1_543_902_791, 5_993 };
        int[] resultDenominator = { 1, 4,  5,  7_000,  8, 6_000, 1,    1, 2_041_507_930,   999 };

        for (int i = 0; i < firstNumerator.length; i++) {
            Fraction f1 = new FractionImpl(firstNumerator[i], firstDenominator[i]);
            Fraction f2 = new FractionImpl(secondNumerator[i], secondDenominator[i]);
            Fraction r = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(f1.add(f2), r);
        }
    }


    @Test
    public void testSubtract() {
        int[] firstNumerator = {    1, 1,  2,  5,  -8,    25, 777,    391_884,  9,  20_000 };
        int[] firstDenominator = {  3, 1,  1,  7,  60, 1_000, 778, 86_409_562,  1,  50_000 };

        int[] secondNumerator = {   2, 1,  1,  6, -45,     1,   7,          0,  1, 140_000 };
        int[] secondDenominator = { 6, 4,  5,  7, 100,     1, 778,          1,  2, 100_000 };

        int[] resultNumerator = {   0, 3,  9, -1,  19,    -39, 770,    391_884, 17,     -1 };
        int[] resultDenominator = { 1, 4, 5,  7,   60,     40, 778, 86_409_562,  2,      1 };


        for (int i = 0; i < firstNumerator.length; i++) {
            Fraction f1 = new FractionImpl(firstNumerator[i], firstDenominator[i]);
            Fraction f2 = new FractionImpl(secondNumerator[i], secondDenominator[i]);
            Fraction r = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(f1.subtract(f2), r);
        }
    }


    @Test
    public void testMultiply() {
        int[] firstNumerator = {    1,  3,   -46,    -932_451,   5,       0, 19,  6_000, 12_468,     1_373_219 };
        int[] firstDenominator = {  2, 30,   150,   1_234_567,   1,       1,  1,  9_000, 55_555, 2_110_492_865 };

        int[] secondNumerator = {   1, -5,   -27,         380,   6,  71_465,  1, -6_000,   200,          1_000 };
        int[] secondDenominator = { 4, 12,    88,         500,   9, 237_557, 19, 12_000,   400,              1 };

        int[] resultNumerator = {   1, -1,  1_242, -35_433_138, 10,       0,   1,   -36,   6234, 1_373_219_000 };
        int[] resultDenominator = { 8, 24, 13_200, 61_728_350,   3,       1,   1,   108, 55_555, 2_110_492_865 };


        for (int i = 0; i < firstNumerator.length; i++) {
            Fraction f1 = new FractionImpl(firstNumerator[i], firstDenominator[i]);
            Fraction f2 = new FractionImpl(secondNumerator[i], secondDenominator[i]);
            Fraction r = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(f1.multiply(f2), r);
        }
    }
}


