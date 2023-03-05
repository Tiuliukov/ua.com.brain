package libs;

import org.aeonbits.owner.ConfigFactory;

/**
 * class which collect test data for login
 */

public class TestData {
    public static ConfigHiddenProperties configHiddenProperties = ConfigFactory.create(ConfigHiddenProperties.class);
    public final static String VALID_LOGIN = System.getProperty("login",configHiddenProperties.login());
    public final static String VALID_PASSWORD = System.getProperty("login",configHiddenProperties.password());
    public final static String INVALID_LOGIN = "+38 (077) 777-77-77";
    public final static String INVALID_PASSWORD = "123";
    public final static String USER_NAME = "Володимир";
}
