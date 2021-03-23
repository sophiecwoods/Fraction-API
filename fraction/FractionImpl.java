package fraction;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;


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
        if (denominator == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        else if (numerator == 0 ) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            // normalises fraction if denominator is negative
            if (denominator < 0) {
                numerator = normaliseFraction(numerator, denominator)[0];
                denominator = normaliseFraction(numerator, denominator)[1];
            } // sets numerator and denominator to simplest form
            int GCD = greatestCommonDivisor(numerator, denominator);
            this.numerator = numerator/GCD;
            this.denominator = denominator/GCD;
        }
    }


    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        numerator = wholeNumber;
        denominator = 1;
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
        // checks String is legal, otherwise throws a NumberFormatException
        String fractionChars = " /-0123456789";
        for (char c : fraction.toCharArray()) {
            if (! fractionChars.contains("" + c)) {
                throw new NumberFormatException("Non numeric input");
            }
        }
        // gets index of forward slash in fraction
        int indexOfSlash = fraction.indexOf("/");

        // if fraction is a whole number, removes whitespace and sets numerator to fraction and denominator to 1
        if (indexOfSlash == -1) {
            numerator = Integer.parseInt(fraction.trim());
            denominator = 1;
            // otherwise creates two substrings of fraction. n holds non whitespace characters before the forward slash
            // and d holds characters after the forward slash.
            // sets numerator and denominator to integer conversions of n and d.
        } else {
            String n = fraction.substring(0, indexOfSlash).trim();
            String d = fraction.substring(indexOfSlash + 1).trim();
            numerator = Integer.parseInt(n);
            denominator = Integer.parseInt(d);
        }

        if (denominator == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        // normalises fraction if denominator is negative
        if (denominator < 0) {
            numerator = normaliseFraction(numerator, denominator)[0];
            denominator = normaliseFraction(numerator, denominator)[1];
        }
        // sets numerator and denominator to simplest form
        int GCD = greatestCommonDivisor(numerator, denominator);
        numerator = numerator/GCD;
        denominator = denominator/GCD;
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        // casts Fraction f to FractionImpl to access numerator and denominator
        int fNumerator = ((FractionImpl) f).numerator;
        int fDenominator = ((FractionImpl) f).denominator;

        // calculates the resulting numerator and denominator, when f is added to this Fraction
        int resultN = (numerator * fDenominator) + (denominator * fNumerator);
        int resultD = denominator * fDenominator;

        // returns a new Fraction which is the result of the addition
        return new FractionImpl(resultN, resultD);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        // casts Fraction f to FractionImpl to access numerator and denominator
        int fNumerator = ((FractionImpl) f).numerator;
        int fDenominator = ((FractionImpl) f).denominator;

        // calculates the resulting numerator and denominator, when f is subtracted from this Fraction
        int resultN = (numerator * fDenominator) - (denominator * fNumerator);
        int resultD = denominator * fDenominator;

        return new FractionImpl(resultN, resultD);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        // casts Fraction f to FractionImpl to access numerator and denominator
        int fNumerator = ((FractionImpl) f).numerator;
        int fDenominator = ((FractionImpl) f).denominator;

        // calculates the resulting numerator and denominator, when this Fraction is multiplied by f
        int resultN = numerator * fNumerator;
        int resultD = denominator * fDenominator;

        return new FractionImpl(resultN, resultD);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        // casts Fraction f to FractionImpl to access numerator and denominator
        int fNumerator = ((FractionImpl) f).numerator;
        int fDenominator = ((FractionImpl) f).denominator;

        // calculates the resulting numerator and denominator, when this Fraction is divded by f
        int resultN = numerator * fDenominator;
        int resultD = denominator * fNumerator;

        return new FractionImpl(resultN, resultD);
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
        // checks that obj is a Fraction
        if (! (obj instanceof Fraction)) {
            return false;
          // creates a FractionImpl instance of obj, f, and checks that the numerator and denominator of f equal the
            // numerator and denominator of the fraction the method is called on
        } FractionImpl f = (FractionImpl) obj;
          return (f.numerator == numerator && f.denominator == denominator);
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
        return String.format("%d/%d", numerator, denominator);
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
     * Returns an array of two integers where, if d is negative, the first integer is the normalised numerator and
     * the second is the normalised denominator, otherwise returns an array of n and d.
     * @param n the numerator of a fraction
     * @param d the denominator of a fraction
     * @return an Array of two integers, the first is the normalised numerator and the second is the normalised
     * denominator
     */
    static int[] normaliseFraction(int n, int d) {
        // if denominator is negative, multiplies the numerator and denominator by -1 to normalise the Fraction
        if (d < 0) {
            n = n * -1;
            d = d * -1;
        }
        // returns a new array of the resulting numerator and denominator
        return new int[]{n, d};
    }
}
