import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

public class CountPrimes {

    public static Callable<Long> countingPrimesViaAtomicInt ( long start, long stop, int n_threads ) {
        AtomicLong candidate = new AtomicLong(start);
        AtomicLong n_primes = new AtomicLong(0);
        return () -> {
            Thread threads[] = new Thread[n_threads];
            for (int t = 0; t < n_threads; t++) {
                threads[t] = new Thread(() -> {
                    while (candidate.get() < stop) {
                        long c = candidate.getAndIncrement();
                        if (c >= stop) break;
                        if (Numbers.isPrime(c)) n_primes.getAndIncrement();
                    }
                });
                threads[t].start();
            }
            for ( Thread t : threads ) t.join();
            return n_primes.get();
        };
    }

    public static void main(String[] args) {
        assert (args.length == 2); // Usage: java CountPrimes <stop> <n_threads>
        long stop = Long.parseLong(args[0]);
        int n_threads = Integer.parseInt(args[1]);
        System.out.format("Counting primes between 1 and %d with %d threads\n",stop,n_threads);
        double executionTime = Stopwatch.startstop(countingPrimesViaAtomicInt(1, stop, n_threads));
        System.out.format("Execution time: %.3fs",executionTime/1e3);
    }
}