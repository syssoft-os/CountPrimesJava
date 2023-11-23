import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.concurrent.Callable;

class NumbersTest {

    @Test
    void isPrime() {
        Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        for (long c = 1; c < 100; c++) {
            assertEquals(primes.contains(Integer.valueOf((int) c)), Numbers.isPrime(c));
        }
    }

    @Test
    void primesCounter() {
        Callable<Long> f = Numbers.primesCounter(1, 100);
        try {
            assertEquals(25, f.call());
        } catch (Exception e) {
            fail("Exception while calling function in primesCounter(): " + e);
        }
    }
}