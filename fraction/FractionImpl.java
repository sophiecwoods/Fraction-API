package fraction;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;


    /**
     * Constructor.
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     *
     * Normalizes the fraction if the denominator is negative and puts the fraction in its simplest form.
     *
     * Throws an <pre>ArithmeticException</pre> if the denominator is zero.
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
     * Constructor.
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        numerator = wholeNumber;
        denominator = 1;
    }


    /**
     * Constructor.
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     *
     * Normalizes the fraction if the denominator is negative and puts the fraction in its simplest form.
     *
     * Allows blanks around (but not within) integers.
     * Throws an <pre>NumberFormatException</pre> if given a malformed string.
     * Throws an <pre>ArithmeticException</pre> if given a string representing a fraction whose denominator is zero.
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

        // calculates the resulting numerator and denominator, when this Fraction is divided by f
        int resultN = numerator * fDenominator;
        int resultD = denominator * fNumerator;

        return new FractionImpl(resultN, resultD);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        // checks if this numerator is negative and if so multiplies it by -1 to get the absolute value
        int resultN = numerator < 0 ? numerator * - 1 : numerator;
        return new FractionImpl(resultN, denominator);
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        // multiplies numerator by -1 to negate this fraction and returns a new fraction
        return new FractionImpl(numerator * -1, denominator);
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
        if (this.numerator == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        // creates a new fraction with this fraction's numerator as its denominator and this fraction's denominator as
        // its numerator.
        int returnN = denominator;
        int returnD = numerator;
        return new FractionImpl(returnN, returnD);
    }


    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        // casts Fraction f to FractionImpl to access numerator and denominator
        int oNumerator = ((FractionImpl) o).numerator;
        int oDenominator = ((FractionImpl) o).denominator;

        int result = 0;
        // if this Fraction and Fraction o have the same denominator, compares the numerators
        if (denominator == oDenominator)
        {
            if (numerator > oNumerator) result = 1;
            else if (numerator < oNumerator) result = -1;
            // otherwise multiplies each numerator by the denominator of the other Fraction to get a common denominator
            // and then compares the numerators
        } else {
            if ((numerator * oDenominator) > (oNumerator * denominator)) result = 1;
            else if ((numerator * oDenominator) < (oNumerator * denominator)) result = -1;
        }
        return result;
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


    // short program that uses the API
    public static void main(String args[]) {

        Fraction f1 = new FractionImpl(2, 4);
        Fraction f2 = new FractionImpl(3);
        Fraction f3 = new FractionImpl("-16/50");
        Fraction f4 = new FractionImpl(1, 999);
        Fraction f5 = new FractionImpl(-30_000);
        Fraction f6 = new FractionImpl("5 / -25");
        Fraction f7 =  new FractionImpl(7, 8);
        Fraction f8 = new FractionImpl("3 /4");
        Fraction f9 = new FractionImpl(75, 100);

        System.out.println("2/4 plus 3 is: " + f1.add(f2));
        System.out.println("1/999 minus -16/50 is: " + f4.subtract(f3));
        System.out.println("-16/50 multiplied by 2/4 is: " + f3.multiply(f1));
        System.out.println("3 divided by -30_000 is: " + f2.divide(f5));
        System.out.println("-16/50 in its simplest form is: " + f3 + ". The absolute value is: " + f3.abs());
        System.out.println("1/999 negated is: " + f4.negate());
        System.out.println("The inverse of 7/8 is " + f7.inverse());
        System.out.println("3/4 equals 75/100? " + f8.equals(f9));
        System.out.println("5/-25 normalised and in its simplest form is " + f6);

        int comparison = f4.compareTo(f1);
        if (comparison > 0) System.out.println(f4 + " is bigger than " + f1);
        else if (comparison < 0) System.out.println(f4 + " is smaller than " + f1);
        else System.out.println(f4 + "is equal to " + f1);
    }
}