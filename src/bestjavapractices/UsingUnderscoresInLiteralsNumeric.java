package bestjavapractices;

/**
 *
 * @author Diego 
 * 
 * Using Underscores in Numeric Literals numeric
 */
public class UsingUnderscoresInLiteralsNumeric {

    // Wrong way
    int maxUploadSizeWrong = 20971520;
    long accountBalanceWrong = 3000000000000L;
    float piWrong = 3141592653589F;

    // Right Way
    int maxUploadSize = 20_971_520;
    long accountBalance = 3_000_000_000_000L;
    float pi = 3.141_592_653_589F;
}
