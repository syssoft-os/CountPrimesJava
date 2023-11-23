import java.util.concurrent.Callable;

class Stopwatch {

    public static double startstop ( Callable<Long> function ) {
        long startTime = System.nanoTime();
        try {
            long result = function.call();
            System.out.format("Result: %d\n", result);
        } catch (Exception e) {
            System.out.println("Exception while calling function in startstop(): " + e);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds
    }

}
