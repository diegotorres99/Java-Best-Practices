package bestjavapractices;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Diego 
 * This class work as "DataBase in memory" for other
 * class(MapAndFlatMap, MapAndReduce, OptionalDemo and others)
 */
public class H2DataBase {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(1_001, "James", "James@gmail.com", Arrays.asList("397937955", "21654725"), "Dev", 160000),
                new Customer(1_002, "Falir", "Falir@gmail.com", Arrays.asList("397937955", "21654725"), "Dev", 260000),
                new Customer(1_003, "Barackt", "Barackt@gmail.com", Arrays.asList("397937955", "21654725"), "Dev", 460000)
        ).collect(Collectors.toList());
    }

    public static class Customer {

        private int id;
        private String name;
        private String email;
        private List<String> phoneNumbers;
        private String grade;
        private double salary;

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public Customer() {
        }

        public Customer(int id, String name, String email, List<String> phoneNumbers, String grade, double salary) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phoneNumbers = phoneNumbers;
            this.grade = grade;
            this.salary = salary;
        }

        public Customer(int id, String name, String grade, double salary) {
            this.id = id;
            this.name = name;
            this.grade = grade;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }

        public Optional<String> getEmailOf() {
            return Optional.of(email);
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }
    }

    static class Student {

        private String name;
        private int age;

        public void setName(String name) {
            if (name == null || name.length() == 0) {
                throw new IllegalArgumentException("Name cannot be Null or Empty");
            }
            this.name = name;
        }

        public void setAge(int age) throws IllegalAccessException {
            if (age < 1 || age > 100) {
                throw new IllegalAccessException("Age is Wrong");
            }
            this.age = age;
        }

        public Student() {
        }
    }
}
