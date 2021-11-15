package bestjavapractices;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Luis Diego Torres 
 * https://github.com/diegotorres99
 */
public class StringBufferAndStringBuilder {

    /**
     * Don't use operartor + to conctanate String's. Example:
     * System.out.println("Name" + userName); Because: Strings are constant and
     * immutable, their values cannot be changed after they are created.
     *
     * Use StringBuilder or StringBuffer instead! Becuase: They support mutable
     * strings and can be shared More information in each method
     */
        private static long startTime = System.nanoTime();
        private static long endTime = System.nanoTime();
        private static long resultTime = 0;

        private static final Map<String, Long> listResult = new HashMap<>();

    public static void main(String[] args) {
        //String Builder and StringBuffer Test time
        StringBufferAndStringBuilder concatenateStrings = new StringBufferAndStringBuilder();
        listResult.put("StringBuffer", concatenateStrings.showStringBuffer());
        listResult.put("StringBuilder", concatenateStrings.showStringBuilder());
    }

    public static long showStringBuilder() {
        //-StringBuilder:
        //      No guarantee of Synchronization in Multi-tasks
        StringBuilder builder = new StringBuilder("This is a new StringBuilder test time!");
        startTime = System.nanoTime();
        System.out.println(String.format("%s ", builder));
        for (int i = 0; i < 1000; i++) {
            builder.append(i);
        }
        endTime = System.nanoTime();
        //  System.err.println(endTime);
        resultTime = (endTime - startTime);
        System.out.println(String.format("-Result test using StringBuilder: %d nanoseconds", resultTime));
        return resultTime;
        //listOfResults.add(resultTime);
    }

    public static long showStringBuffer() {
        // -StringBuffer:
        //      A Thread-safe, mutable sequence of caracters
        //      is a safe use by multiple thread, the methods are synchronized where is necesary

        StringBuffer buffer = new StringBuffer("This is a new StringBuffer test time!");
        System.err.println(buffer);
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            buffer.append(i);
        }
        endTime = System.nanoTime();
        //  System.err.println(endTime);
        resultTime = (endTime - startTime);
        System.out.println(String.format("-Result test using StringBuffer: %d nanoseconds\n", resultTime));
        System.out.println("*********************************************\n");
        return resultTime;
    }

}
