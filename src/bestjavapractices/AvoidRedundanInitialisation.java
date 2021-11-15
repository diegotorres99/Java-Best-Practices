package bestjavapractices;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Diego
 */
public class AvoidRedundanInitialisation {

    /* Rule:
    Avoid Redundant Initialisation
    Example:
     */
    public class Person {

        private final String name = null;
        private final int age = 0;
        private final boolean isGenius = true;
        private final long idUser = 0L;
        private final float idGrade = 0.0F;
        private final BigDecimal bigDecimal = new BigDecimal(BigInteger.ZERO);

    }
}
