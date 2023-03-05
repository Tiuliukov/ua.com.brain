package libs;

import org.aeonbits.owner.Config;

/**
 *interface for working with config.properties file. Methods returns data from file for configuring progect parameters
 * (like Waiters)
 */

@Config.Sources(value = "file:./src/main/java/resources/config.properties")
public interface ConfigProperties extends Config {
	long TIME_FOR_DEFAULT_WAIT();
	long TIME_FOR_EXPLICIT_WAIT_LOW();
	long TIME_FOR_EXPLICIT_WAIT_HIGH();
}
