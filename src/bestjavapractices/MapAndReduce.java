/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestjavapractices;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diego
 *
 * Using Map and Reduce for many operations in List You can reduce and filter
 * information with methods Examples with numbers and EmployeeDatabase
 *
 * Important: Use BigDecimal, not double to manage salary in development
 * environment
 */
public class MapAndReduce {

    private static final List<H2DataBase.Customer> EmployeeDatabase = H2DataBase.getAll();
    private static final List<String> words = Arrays.asList("JAVA SPRING BOOT", "SPRING", "PHP");
    private static final List<Integer> numbers = Arrays.asList(3, 6, 9, 3, 6, 9);

    public static void main(String[] args) {

        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(String.format("Using MapToInt: %s \n", sum1));

        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(String.format("Using reduce: %s \n", reduceSum));

        Optional<Integer> reduceSumUsingMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println(String.format("Using Reduce with method reference: %s \n", reduceSumUsingMethodReference));

        long mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(String.format("Using reduce for multiply: %s \n", mulResult));

        Integer maxValue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(String.format("Using reduce for find Max value: %s \n", maxValue));

        Integer maxValueWithMethodReferences = numbers.stream().reduce(Integer::max).get();
        System.out.println(String.format("Find Max Value with method References: %s \n", maxValueWithMethodReferences));

        String longestString = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(String.format("Find longest string with Reduce: %s \n", longestString));
        //get employee whose grade is Dev
        double avgSalary = EmployeeDatabase.stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("Dev"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println(String.format("Employee whose grade is Dev: %s \n", avgSalary));
        //Get salary
        double sumSalary = EmployeeDatabase.stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("Dev"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .sum();
        System.out.println(String.format("Sum Salary: %s", sumSalary));
    }
}
