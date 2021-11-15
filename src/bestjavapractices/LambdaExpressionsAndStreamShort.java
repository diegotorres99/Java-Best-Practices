package bestjavapractices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Diego
 * 
 *  Using Lambda Expressions an Strem to short Map
 * 
 */
public class LambdaExpressionsAndStreamShort {

    private static long startTime = System.nanoTime();
    private static long endTime = System.nanoTime();
    private static long resultTime = 0;

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);

        List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        //Short using LambdaExpressions
        startTime = System.nanoTime();
        Collections.sort(entries, (t, t1) -> t.getValue().compareTo(t1.getValue()));
        for (Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
        endTime = System.nanoTime();

        resultTime = (endTime - startTime);

        System.out.println("************************************");
        System.out.println(String.format("-Result test using Lambda expression: %d nanoseconds\n", resultTime));
           
        startTime = System.nanoTime();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        endTime = System.nanoTime();

        resultTime = (endTime - startTime);

        System.out.println("************************************");
        System.out.println(String.format("-Result test using Stream: %d nanoseconds", resultTime));
        //Short Map by Value
        //map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
}
