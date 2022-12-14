package fraction;

import static org.junit.Assert.*;
import org.junit.*;

public class FractionImplTest {


    /*
     * Creates valid instances of Fraction using numerator denominator constructor
     */
    @Test
    public void testNumeratorDenominatorConstructor() {

        int[] nums1 = {        1,  4, 7, -12, -300,    708,  -200_000, 0, 64_389, -1_000_000 };
        int[] nums2 = {        6, 30, 1, -13,  500, -4_513, 7_000_000, 1,    123,  9_999_999 };

        int[] numerators = {   1,  2, 7,  12,   -3,   -708,        -1, 0, 64_389, -1_000_000 };
        int[] denominators = { 6, 15, 1,  13,    5,  4_513,        35, 1,    123,  9_999_999 };

        for (int i = 0; i < nums1.length; i++) {
            Fraction input = new FractionImpl(nums1[i], nums2[i]);
            Fraction result = new FractionImpl(numerators[i], denominators[i]);
            assertEquals(input, result);
        }
    }


    /*
     * Creates invalid instance of Fraction, with zero as the denominator, using numerator denominator constructor
     */
    @Test(expected = ArithmeticException.class)
    public void testZeroDenominator() {
        Fraction f = new FractionImpl(1, 0);
    }


    /*
     * Creates valid instances of Fraction using whole number constructor
     */
    @Test
    public void testWholeNumberConstructor() {

        int[] wholeNums = {    3, 65, 27_604, 123_456_789, 2_147_483_647, -50, -71_452, -2_147_483_647, 0, 1 };
        int[] numerators = {   3, 65, 27_604, 123_456_789, 2_147_483_647, -50, -71_452, -2_147_483_647, 0, 1 };
        int[] denominators = { 1,  1,      1,           1,             1,   1,       1,              1, 1, 1 };

        for (int i = 0; i < wholeNums.length; i++) {
            Fraction input = new FractionImpl(wholeNums[i]);
            Fraction result = new FractionImpl(numerators[i], denominators[i]);
            assertEquals(input, result);
        }
    }


    /*
     * Creates valid instances of Fraction using String constructor
     */
    @Test
    public void testStringConstructor() {

        String[] strings = {  "1", "-8", "-36490", "9356771", "0", "22/45", "30 / 90", "-100 /650", "-2/ -17", "5/1" };
        int[] numerators = {   1,   -8,  -36_490,  9_356_771,  0,      22,         1,         -10,         2,     5 };
        int[] denominators = { 1,    1,        1,          1,  1,      45,         3,          65,        17,     1 };

        for (int i = 0; i < strings.length; i++) {
            Fraction input = new FractionImpl(strings[i]);
            Fraction result = new FractionImpl(numerators[i], denominators[i]);
            assertEquals(input, result);
        }
    }


    /*
     * Creates invalid instance of Fraction, with malformed Strings, using String constructor
     */
    @Test(expected = NumberFormatException.class)
    public void testIllegalString() {
        Fraction f1 = new FractionImpl("a");
        Fraction f2 = new FractionImpl("1 5/20");
        Fraction f3 = new FractionImpl("2/- 8");
    }


    /*
     * Tests GreatestCommonDivisor method on an array of numbers. GreatestCommonDivisor method is static as it can be
     * used without an instance of Fraction.
     */
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


    /*
     * Tests NormaliseFraction method on an array of numbers. NormaliseFraction method is static as it can be
     * used without an instance of Fraction.
     */
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


    /*
     * Creates instances of Fraction and tests add method on them
     */
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
            Fraction result = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(f1.add(f2), result);
        }
    }


    /*
     * Creates instances of Fraction and tests subtract method on them
     */
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
            Fraction result = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(f1.subtract(f2), result);
        }
    }


    /*
     * Creates instances of Fraction and tests multiply method on them
     */
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
            Fraction result = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(f1.multiply(f2), result);
        }
    }


    /*
     * Creates instances of Fraction and tests divide method on them
     */
    @Test
    public void testDivide() {
        int[] firstNumerator = {    1,  20, -145,  800,    9, 3_442,         -5,  99,  -12_000,    -62 };
        int[] firstDenominator = {  2,  39,  147,    1,    5,     1,         25, 100,   16_000,    100 };

        int[] secondNumerator = {   1,   7,    3,    1,   250,    1,  1_000_000,   2,       -3,   -574 };
        int[] secondDenominator = { 2,   8,    4,   10,   600,    2,          1,   3,       40,    777 };

        int[] resultNumerator = {   1, 160, -580, 8_000,  108, 6_884,        -1, 297,       10,  3_441 };
        int[] resultDenominator = { 1, 273,  441,     1,   25,     1, 5_000_000, 200,        1,  4_100 };

        for (int i = 0; i < firstNumerator.length; i++) {
            Fraction f1 = new FractionImpl(firstNumerator[i], firstDenominator[i]);
            Fraction f2 = new FractionImpl(secondNumerator[i], secondDenominator[i]);
            Fraction result = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(f1.divide(f2), result);
        }
    }


    /*
     * Creates instances of Fraction that are equal and test equals method on them
     */
    @Test
    public void testEqualsTrue() {
        int[] firstNumerator = {    1,  1,  -12, 50, 8_000 };
        int[] firstDenominator = {  2,  3,  120,  1,     2 };

        int[] secondNumerator =   { 1,  2,   -1, 50, 4_000 };
        int[] secondDenominator = { 2,  6,   10,  1,     1 };

        for (int i = 0; i < firstNumerator.length; i++) {
            Fraction f1 = new FractionImpl(firstNumerator[i], firstDenominator[i]);
            Fraction f2 = new FractionImpl(secondNumerator[i], secondDenominator[i]);
            assertTrue(f1.equals(f2));
        }
    }


    /*
     * Creates instances of Fraction that are not equal and test equals method on them
     */
    @Test
    public void testEqualsFalse() {
        int[] firstNumerator = {    -2, -7_846, -350_630_490,  2_478_222, 40,   900 };
        int[] firstDenominator = {   5, 30_000,            1,          1, 50, 1_000 };

        int[] secondNumerator =   {  2, -7_845, -350_630_490,  2_478_222, 41,    90 };
        int[] secondDenominator = {  5, 30_000,            2, 10_000_000, 51, 1_000 };

        for (int i = 0; i < firstNumerator.length; i++) {
            Fraction f1 = new FractionImpl(firstNumerator[i], firstDenominator[i]);
            Fraction f2 = new FractionImpl(secondNumerator[i], secondDenominator[i]);
            assertFalse(f1.equals(f2));
        }
    }


    /*
     * Creates instances of Fraction and tests toString method on them
     */
    @Test
    public void testToString() {
        int[] numerators = {    4, 62, -1_654, 395, 600_000,         27, -87_145, 0, 16 };
        int[] denominators = { 19, 63, 57_821,  11, 932_653, 28_000_000,       1, 1,  1 };
        String[] results =  {"4/19", "62/63", "-1654/57821", "395/11", "600000/932653", "27/28000000",
                                "-87145/1", "0/1", "16/1"};

        for (int i = 0; i < numerators.length; i++) {
            Fraction f = new FractionImpl(numerators[i], denominators[i]);
            assertEquals(f.toString(), results[i]);
        }
    }


    /*
     * Creates instances of Fraction and tests abs method on them
     */
    @Test
    public void testAbs() {
        int[] numerators = {        5, -1,   490, 834_981_202,  -2_111_579_886,    -675, -180, 0 };
        int[] denominators = {      6,  3, 6_253,           1,               1,  29_437,   67, 1 };

        int[] resultNumerator = {   5,  1,   490, 834_981_202,   2_111_579_886,     675,  180, 0 };
        int[] resultDenominator = { 6,  3, 6_253,           1,               1,  29_437,   67, 1 };

        for (int i = 0; i < numerators.length; i++) {
            Fraction input = new FractionImpl(numerators[i], denominators[i]);
            Fraction result = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(input.abs(), result);
        }
    }


    /*
     * Creates instances of Fraction and tests negate method on them
     */
    @Test
    public void testNegate() {
        int[] numerators =        { 5, -1,   490,  834_981_202, -2_111_579_886,    -675, -180, 0 };
        int[] denominators =      { 6,  3, 6_253,            1,              1,  29_437,   67, 1 };

        int[] resultNumerator = {  -5,  1,  -490, -834_981_202,  2_111_579_886,     675,  180, 0 };
        int[] resultDenominator = { 6,  3, 6_253,            1,              1,  29_437,   67, 1 };

        for (int i = 0; i < numerators.length; i++) {
            Fraction input = new FractionImpl(numerators[i], denominators[i]);
            Fraction result = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(input.negate(), result);
        }
    }


    /*
     * Creates instances of Fraction and tests inverse method on them
     */
    @Test
    public void testInverse() {
        int[] numerators =        { 5, -1,   490, 834_981_202, -2_111_579_886,    -675, -180, 30 };
        int[] denominators =      { 6,  3, 6_253,           1,              1,  29_437,   67,  1 };

        int[] resultNumerator = {   6, -3, 6_253,           1,             -1, -29_437,  -67,  1 };
        int[] resultDenominator = { 5,  1,   490, 834_981_202,  2_111_579_886,     675,  180, 30 };

        for (int i = 0; i < numerators.length; i++) {
            Fraction input = new FractionImpl(numerators[i], denominators[i]);
            Fraction result = new FractionImpl(resultNumerator[i], resultDenominator[i]);
            assertEquals(input.inverse(), result);
        }
    }


    /*
     * Creates instance of Fraction with zero as the numerator and tests that calling inverse method throws an exception
     */
    @Test(expected = ArithmeticException.class)
    public void testInverseZero() {
        Fraction f = new FractionImpl(0, 1);
        f.inverse();
    }


    /*
     * Creates instances of Fraction and tests compareTo method on them
     */
    @Test
    public void testCompareTo() {
        int[] firstNumerator = {    1,  3,  -12, -2, -7_846, -350_630_490, -2_478_222,     25,  9,     99 };
        int[] firstDenominator = {  2,  9,  120,  5, 30_000,            1,          1, 3_4421,  1,    100 };

        int[] secondNumerator =   { 1,  1,   -1,  2, -7_845,  -4_379_224,  -2_478_222,      0, 37, 70_000 };
        int[] secondDenominator = { 2,  3,   10,  5, 30_000,           1,  10_000_000,      1,  6, 80_000 };

        int[] results =          {  0,  0,    0, -1,     -1,          -1,          -1,      1,  1,      1 };

        for (int i = 0; i < firstNumerator.length; i++) {
            Fraction f1 = new FractionImpl(firstNumerator[i], firstDenominator[i]);
            Fraction f2 = new FractionImpl(secondNumerator[i], secondDenominator[i]);
            assertEquals(f1.compareTo(f2), results[i]);
        }
    }
}
