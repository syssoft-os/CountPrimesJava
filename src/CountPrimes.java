import java.util.concurrent.Callable;
import java.util.stream.LongStream;

public class CountPrimes {
    public static Callable<Long> countingPrimesUsingJavaStreams ( long start, long stop ) {
        return () -> {
            return LongStream.rangeClosed(start, stop)
                    .filter(Numbers::isPrime)  // Filter the stream to include only prime numbers
                    .count();
        };
    }

    public static void main(String[] args) {
        assert (args.length == 1) : "Usage: java CountPrimes <stop>";
        long stop = Long.parseLong(args[0]);
        System.out.format("Counting primes between 1 and %d\n",stop);
        double executionTime = Stopwatch.startstop(countingPrimesUsingJavaStreams(1, stop));
        System.out.format("Execution time: %.3fs",executionTime/1e3);
    }
}