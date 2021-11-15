package bestjavapractices;
/**
 *
 * @author Diego
 */
public class AvoidUsingLoops {
/*
    Rule: Avoid using for loops with indexes
    Examples:
*/
    private static long startTime = System.nanoTime();
    private static long endTime = System.nanoTime();
    private static long resultTime = 0;
    
    public static void main(String[] args) {
        //Wrong way, avoid this 
        String[] names = {"Luis", "Diego", "Mark", "Karol", "Vale", "Frank"};
  
        startTime = System.nanoTime();
        for (int i = 0; i < names.length; i++) {
             System.out.println(names[i]);
        }
        endTime = System.nanoTime();
        resultTime = (endTime-startTime);
        System.out.println("------------------------");
        System.out.println(String.format("*Result test time using loops: %d nanoseconds\n", resultTime));
        
        
        //Replace with this instead!
        startTime = System.nanoTime();
        for (String showName : names) {
              System.out.println(showName);
        }
        endTime = System.nanoTime();
        resultTime = (endTime-startTime);
        System.out.println("------------------------");
        System.out.println(String.format("*Result test time without loops: %d nanoseconds", resultTime));
    }
}
