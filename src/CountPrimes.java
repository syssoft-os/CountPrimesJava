import java.util.concurrent.Callable;

public class CountPrimes {
    public static void main(String[] args) {
        assert (args.length == 1) : "Usage: java CountPrimes <stop>";
        long stop = Long.parseLong(args[0]);
        System.out.format("Counting primes between 1 and %d\n",stop);
        double executionTime = Stopwatch.startstop(Numbers.primesCounter(1, stop));
        System.out.format("Execution time: %.3fs",executionTime/1e3);
    }
}