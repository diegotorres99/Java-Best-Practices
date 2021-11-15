package bestjavapractices;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diego 
 * Using Empty,ofNullable and of 
 * 
 * If you use Optional.of and the value is
 * null result is equals to: NullPointerException
 *
 * Use Optional.ofNullable, is the best way, result is equals to Optional.empty
 *
 */
public class OptionalDemo {

    private static final H2DataBase.Customer customer = new H2DataBase.Customer(101, "john", "kely@gmail.com", Arrays.asList("397937955", "21654725"), null, 0);
    private static final H2DataBase.Customer customerNull = new H2DataBase.Customer(101, "john", null, Arrays.asList("397937955", "21654725"), null, 0);

    private static H2DataBase.Customer getCustomerByEmailId(String email) throws Exception {
        List<H2DataBase.Customer> customers = H2DataBase.getAll();
        for (H2DataBase.Customer c : customers) {
            System.err.println(c.getEmail());
        }
        return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst().orElseThrow(() -> new Exception("no customer present with this email id"));
    }

    public static void main(String[] args) throws Exception {

        //empty
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(String.format("Using Optional *Empty: %s \n", emptyOptional));

        //ofNullable
        Optional<Object> emailOptional = Optional.ofNullable((Optional<String>) customer.getEmail());
        System.out.println(String.format("Using Optional *ofNullable: %s \n", emailOptional));

        //of  
        //if no present, return NullPointerException
        Optional<Object> emailOptionalOf = Optional.of(customer.getEmailOf());
        Optional<Object> emailOptionalOfNull = Optional.ofNullable(customerNull.getEmail());

        if (emailOptionalOf.isPresent()) {
            System.out.println(String.format("Using Optional *of: %s \n", emailOptional));
        }
        //System.out.println(emailOptionalOfNull.orElse("default@email.com"));
        //System.out.println(emailOptionalOf.orElseThrow(() -> new IllegalArgumentException("email not present")));
        // System.out.println(emailOptionalOfNull.map(String::toUpperCase).orElseGet(()->"default email..."));
        //getCustomerByEmailId(customer.getEmail().toString());
    }

}
