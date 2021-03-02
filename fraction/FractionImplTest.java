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
}


