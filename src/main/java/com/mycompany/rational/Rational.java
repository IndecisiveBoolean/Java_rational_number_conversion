package com.mycompany.rational;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {

    // Create data fields for "numerator" and "denominator"
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    // Construct a rational with default properties utilizing the above data fields
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // Construct a rational with specified numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = (denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : BigInteger.ONE.negate())
                .multiply(numerator).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    // Find Greatest Common Denominator of the given numbers from the user
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = BigInteger.ONE;

        for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) {// this for loop will use the methods located after the // GETTERS // segment below to retur
            if (n1.remainder(k).equals(BigInteger.ZERO) && n2.remainder(k).equals(BigInteger.ZERO)) {
                gcd = k;
            }
        }

        return gcd;
    }

//    GETTERS START     //
    // Get and return numerator 
    public BigInteger getNumerator() {
        return numerator;
    }

    // Get and return denominator
    public BigInteger getDenominator() {
        return denominator;
    }

//    GETTERS END     //
    // Add a rational number to this rational
    public Rational add(Rational currentRational) {
        BigInteger n = numerator.multiply(currentRational.getDenominator())
                .add(denominator.multiply(currentRational.getNumerator()));
        BigInteger d = denominator.multiply(currentRational.getDenominator());
        return new Rational(n, d);
    }

    // Subtract a rational number from this rational
    public Rational subtract(Rational currentRational) {
        BigInteger n = numerator.multiply(currentRational.getDenominator())
                .subtract(denominator.multiply(currentRational.getNumerator()));
        BigInteger d = denominator.multiply(currentRational.getDenominator());
        return new Rational(n, d);
    }

    // Multiply a rational number by this rational
    public Rational multiply(Rational currentRational) {
        BigInteger n = numerator.multiply(currentRational.getNumerator());
        BigInteger d = denominator.multiply(currentRational.getDenominator());
        return new Rational(n, d);
    }

    // Divide a rational number by this rational
    public Rational divide(Rational currentRational) {
        BigInteger n = numerator.multiply(currentRational.getDenominator());
        BigInteger d = denominator.multiply(currentRational.getNumerator());
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0) {
            return 1;
        } else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
