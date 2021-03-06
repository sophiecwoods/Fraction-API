package fraction;

import static org.junit.Assert.*;
import org.junit.*;

public class FractionImplTest {

    @Test
    public void testGreatestCommonDivisor() {

        int[] nums1 = {1, 1, 3, 4,  5, 124, 192, 13, 0, 0,  -50, 66};
        int[] nums2 = {1, 2, 3, 2, 10,  16, 270, 99, 7, 0, -100, -6};
        int[] GCD = {  1, 1, 3, 2,  5,   4,   6,  1, 7, 0,   50,  6};

        for (int i = 0; i < nums1.length; i++) {
            int result = FractionImpl.greatestCommonDivisor(nums1[i], nums2[i]);
            assertEquals(result, GCD[i]);
        }
    }

    @Test
    public void testNormaliseFraction() {
        int[] numeratorIn = {    0, 1, 5,  6,  8,  125, -20, -33 };
        int[] denominatorIn = {  1, 2, 1, -1, -4, -489, -50, 100 };
        int[] numeratorOut = {   0, 1, 5, -6, -8, -125,  20, -33 };
        int[] denominatorOut = { 1, 2, 1,  1,  4,  489,  50, 100 };

        for (int i = 0; i < numeratorIn.length; i++) {
            int[] results = FractionImpl.normaliseFraction(numeratorIn[i], denominatorIn[i]);
            assertEquals(results[0], numeratorOut[i]);
            assertEquals(results[1], denominatorOut[i]);
        }
    }
}


