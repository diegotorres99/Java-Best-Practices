package bestjavapractices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Diego
 */
public class MapAndFlatMap {

    private static final List<H2DataBase.Customer> customers = H2DataBase.getAll();

    public static void main(String[] args) {

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  one to one mapping
        List<Optional<String>> emails = customers.stream()
                .map(customer -> customer.getEmail())
                .collect(Collectors.toList());
        System.out.println(String.format("Example with Map (One to One Mapping) %s\n", emails));

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(String.format("Example with flatMap (One to Many Mapping) %s\n", phones));
    }
}
