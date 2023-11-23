# Mac Pro (3,5 GHz 6-Core Intel Xeon E5, 32 GB 1866 MHz DDR3)

1. Sequential (For-Schleife): 10^8, 197.714s
2. Sequential (Java Streams): 10^8, 197.389s
3. Parallel (Java Streams): 10^8, 30.346s
4. Parallel (AtomicLong): 10^8, 37,040s, 6 Threads
5. Parallel (AtomicLong): 10^8, 29,782s, 12 Threads
6. Parallel (AtomicLong): 10^8, 29,869s, 24 Threads