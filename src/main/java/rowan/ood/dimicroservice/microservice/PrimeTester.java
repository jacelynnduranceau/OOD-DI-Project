package rowan.ood.dimicroservice.microservice;

/**
 * @author Dr. Baliga
 *
 * Interface of the prime tester
 *
 *
 */

public interface PrimeTester {
    // Returns true if the number is a prime number, False otherwise
    // String used a parameter to accommodate testing of arbitrary sized prime numbers
    boolean isPrime(String number);
}