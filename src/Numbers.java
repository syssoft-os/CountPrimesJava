import java.util.concurrent.Callable;

public class Numbers {

    public static boolean isPrime ( long candidate ) {
        if ( candidate < 2) return false;
        if (candidate == 2) return true;
        if (candidate % 2 == 0) return false;
        long divisor = 3;
        while (divisor * divisor <= candidate) {
            if (candidate % divisor == 0) return false;
            divisor += 2;
        }
        return true;
    }

    public static Callable<Long> primesCounter ( long start, long end ) {
        return () -> {
            long count = 0;
            for (long c = start; c < end; c++) {
                if (isPrime(c)) count++;
            }
            return count;
        };
    }

}
