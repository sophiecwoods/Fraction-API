# Principles of Programming II coursework

Coursework project to build a Fraction API for the module Principles of Programming II as part of the MSc Computer Science at Birkbeck, University of London.

## The task 
Java provides several types of numbers, but it does not provide fractions. Your task is to implement a Fraction API and write a small program that uses it.

## Purpose of this assignment

* To give you practice with creating classes.
* To give you practice reading the API.
* To give you more practice with string manipulation.
* To give you practice creating ```Javadoc``` files.

## General idea of the assignment
* Implement the ```Fraction``` API (see interface ```Fraction```)
* Write very thorough JUnit tests.

## The API
The following lists some information about your new Fraction type:

**Instance variables**

Two ```private``` integers, known as the ```numerator``` and the ```denominator```. Do not provide public accessors or mutators (getters or setters) for these instance variables; there is no reason for anything outside the ```FractionImpl``` class to know about them.

**Written as**
```n/d```, where ```n``` is the numerator and ```d``` is the denominator.

**Restrictions** 

The denominator may not be zero.

**Normalisation**
* The fraction is always kept in the lowest terms, that is, the Greatest Common Divisor (GCD) of ```n``` and ```d``` is 1 (use Euclid's algorithm).
* The denominator is never negative. (You can give a negative number for the denominator to the constructor when you create the fraction, but a negative fraction should be represented internally with a negative numerator.)
* Zero should be represented as 0/1.

The following lists the constructors you should have (please note that Java does not allow constructors to be specified in an interface, hence the use of FractionImpl):

Constructor |	How it uses its parameters
------------| ---------------------------
```public FractionImpl(int numerator, int denominator)```	| Parameters are the numerator and the denominator. Normalize the fraction as you create it. For instance, if the parameters are (8, -12), create a ```Fraction``` with numerator -2 and denominator 3. The constructor should throw an ```ArithmeticException``` if the denominator is zero.
```public FractionImpl(int wholeNumber)```	| The parameter is the numerator and 1 is the implicit denominator.
```public FractionImpl(String fraction)```	| The parameter is a ```String``` containing either a whole number, such as "5" or "-3", or a fraction, such as "8/-12". Allow blanks around (but not within) integers. The constructor should throw an ```ArithmeticException``` if given a string representing a fraction whose denominator is zero. You may find it helpful to look at the available String methods in the Java API.

<br/>
The following lists the methods you should have:
<br/> <br/>

Method signature | What it does
----------       | -----------
```public Fraction add(Fraction f)```	| Returns a new ```Fraction``` that is the **sum** of ```this``` and ```that```: <br/> a/b + c/d is (ad + bc)/bd
```public Fraction subtract(Fraction f)``` | Returns a new ```Fraction``` that is the **difference** of ```this``` minus ```that```: <br/> a/b - c/d is (ad - bc)/bd
```public Fraction multiply(Fraction f)``` | Returns a new ```Fraction``` that is the **product** of ```this``` and ```that```: <br/> (a/b) * (c/d) is (a*c)/(b*d)
```public Fraction divide(Fraction f)``` | Returns a new ```Fraction``` that is the **quotient** of dividing ```this``` by ```that```: <br/> (a/b) / (c/d) is (a*d)/(b*c)
```public Fraction abs()``` |	Returns a new ```Fraction``` that is the absolute value of ```this``` fraction.
```public Fraction negate()```	| Returns a new ```Fraction``` that has the same numeric value of ```this``` fraction, but the opposite sign.
```public Fraction inverse()```	| The inverse of ```a/b``` is ```b/a```.
```@Override``` <br/> ```public boolean equals(Object o)```	| Returns ```true``` if ```o``` is a ```Fraction``` equal to this, and ```false``` in all other cases.
```@Override``` <br/> ```public int compareTo(Object o)``` |	If ```o```is a ```Fraction``` or an ```int```, this method returns: <ul><li/> A negative int if this is less than o. <li/> Zero if ```this``` is equal to ```o```. <li/> A positive ```int``` if ```this``` is greater than ```o```. </ul> If ```o``` is neither a ```Fraction``` nor an ```int```, this method throws a ```ClassCastException```.
```@Override``` <br/> ```public String toString()``` |	Returns a ```String``` of the form n/d, where ```n``` is the numerator and ```d``` is the denominator. <br/> However, if ```d``` is 1, just return ```n``` (as a String). <br/> The returned ```String``` should not contain any blanks. <br/> If the fraction represents a negative number, a minus sign should precede n. <br/>This should be one of the first methods you write, because it will help you in debugging.

**Notes:**
* All ```Fraction```s should be immutable, that is, there should be no way to change their components after the numbers have been created. Most of your methods simply return a new number.
* You can create additional "helper" methods (for example, to compute the GCD, or to normalise a fraction), if you wish; we recommend doing so. If you do, do not make these methods ```public```, but do test them (if you can figure out how).

To put a fraction into its lowest terms, divide both the numerator and the denominator by their Greatest Common Divisor (GCD); Euclid's algorithm finds the GCD of two integers. It works as follows:

As long as the two numbers are not equal, replace the larger number with the remainder of dividing the larger by the smaller (that is, ```larger = larger % smaller```).
When the two numbers are equal, that value is the GCD.
(If this brief explanation isn't enough, look up Euclid's algorithm on the Web.)

## JUnit testing
Your goal in writing the JUnit class is to test for every possible error. This includes making sure that the correct Exceptions are thrown when appropriate. You can find the various kinds of assertions you can use in the JUnit API.

## Javadoc
All methods in your Fraction class should have Javadoc comments. The methods in your test class do not need to be commented, unless they are particularly complex or non-obvious. 
