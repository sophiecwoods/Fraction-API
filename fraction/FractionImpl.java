package fraction;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    public FractionImpl(int numerator, int denominator) {
        // TODO
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        // TODO
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        // TODO
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return null;
    }


    /**
     * Returns an integer that is the greatest common divisor of parameters num1 and num2
     * @param num1 the first number in the computation
     * @param num2 the second number in the computation
     * @return the greatest common divisor of num1 and num2
     */
    static int greatestCommonDivisor(int num1, int num2){
        int larger;
        int smaller;
        int remainder;
        // checks whether num1 is greater than num2 and assigns num1 and num2 to larger and smaller accordingly
        if (Math.abs(num1) > Math.abs(num2)) {
            larger = Math.abs(num1);
            smaller = Math.abs(num2);
        } else {
            larger = Math.abs(num2);
            smaller = Math.abs(num1);
        }

        /* Uses Euclid's algorithm to calculate the greatest common divisor. While larger and smaller do not equal zero,
           divide the larger number by the smaller number and then assign the smaller number to larger and the remainder
           to smaller.
         */
        if (larger != 0) {
            while (smaller != 0) {
                remainder = larger % smaller;
                larger = smaller;
                smaller = remainder;
            }
        }
        return larger;
    }

    /**
     * Returns an array of two integers where if d is negative the first integer is the normalised numerator and
     * the second is the normalised denominator, otherwise returns an array of n and d.
     * @param n the numerator of a fraction
     * @param d the denominator of a fraction
     * @return an Array of two integers, the first is the normalised numerator and the second is the normalised
     * denominator
     */
    static int[] normaliseFraction(int n, int d) {
        if (d < 0) {
            n = n * -1;
            d = d * -1;
        }
        return new int[]{n, d};
    }
}