package bestjavapractices;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Diego
 *
 * If they do financial systems, small calculation errors accumulated with
 * several pennies can result in reports whose calculations will differ from the
 * operations that humans normally perform.
 *
 * To solve this problem, the BigDecimal class is included in Java, which
 * although it performs the calculations slower than "Double / double", performs
 * them in the same way as humans (in base 10) and thus we avoid the problem(:
 */
public class FinancialCalculationsWithBigDecimal {

    private static final double oneCent = 0.01;
    private static final BigDecimal unCentavo = new BigDecimal("0.01");

    private static BigDecimal totalBigDecimal = new BigDecimal(BigInteger.ZERO);

    public static void main(String[] args) {
        //*Wrong way , add 6 cent
        double totalDouble = oneCent + oneCent + oneCent + oneCent + oneCent + oneCent;
        System.out.println(String.format("Result using Double: $%f", totalDouble));

        //Best way, using BigDecimal !
        totalBigDecimal = unCentavo.add(unCentavo).add(unCentavo).add(unCentavo).add(unCentavo).add(unCentavo);
        System.out.println(String.format("\nResult using Big Decimal: $%s", totalBigDecimal));
    }

}
