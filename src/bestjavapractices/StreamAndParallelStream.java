package bestjavapractices;

import java.util.stream.IntStream;

/**
 *
 * @author Diego 
 * 
 * Parrarel Stream: for multiples threads in one task
 * Plain Stream: use One thread for task
 * 
 */
public class StreamAndParallelStream {

    private static long start = 0;
    private static long end = 0;

    public static void main(String[] args) {

        start = System.nanoTime();
        IntStream.range(1, 10).forEach(System.out::println);
        end = System.nanoTime();
        System.out.println(String.format("\n Plain stream(One Thread) took time : %s \n ", (end - start)));

        start = System.nanoTime();
        IntStream.range(1, 10).parallel().forEach(System.out::println);
        end = System.nanoTime();
        System.out.println(String.format("\n Parallel stream (Multiples Thread ) took time : %s \n", (end - start)));

        //Get Thread and uses 
        System.out.println("Using Plain Stream:\n");
        IntStream.range(1, 10).forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
        });
        System.out.println("\nUsing Parllel Stream:\n");
        IntStream.range(1, 10).parallel().forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
        });

    }

}
