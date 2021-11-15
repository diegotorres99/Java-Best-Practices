package bestjavapractices;

import java.util.Optional;

/**
 *
 * @author Diego
 */
public class StringFormat {

    /**
     *
     * Don't use operartor + to conctanate String's.
     *
     * Use String.format() can be more easily localised with text loaded from
     * resource files whereas concatenation can't be localised without producing
     * a new executable with different code for each language. Example:
     */
    private static final Optional<Object> emptyProduct = Optional.empty();
    private static final long idProduct = 10_999_523L;

    public static void main(String[] args) throws Exception {

        if (emptyProduct.isPresent()) {
            System.out.println("Product is Present");
        } else {
            //Show Exeption with String.Format
            throw new Exception(String.format("The product with id [%d] does not exist !", idProduct));
        }
    }
}
