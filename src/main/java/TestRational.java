
import java.math.BigInteger;
import java.util.Scanner;
import com.mycompany.rational.Rational;

public class TestRational {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the first rational number
        System.out.print("Enter the first rational number (numerator): ");
        BigInteger numerator1 = input.nextBigInteger();
        BigInteger denominator1 = input.nextBigInteger();

        // Prompt the user to enter the second rational number
        System.out.print("Enter the second rational number (denominator): ");
        BigInteger numerator2 = input.nextBigInteger();
        BigInteger denominator2 = input.nextBigInteger();

        // New objects are created using the above obtained rational numbers
        Rational rational1 = new Rational(numerator1, denominator1);
        Rational rational2 = new Rational(numerator2, denominator2);

        // Formatted output of Rational conversion via methods in "Rational.java"
        System.out.println(rational1 + " + " + rational2 + " = " + rational1.add(rational2));
        System.out.println(rational1 + " - " + rational2 + " = " + rational1.subtract(rational2));
        System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2));
        System.out.println(rational1 + " / " + rational2 + " = " + rational1.divide(rational2));
        System.out.println(rational2 + " is " + rational2.doubleValue());
    }
}
