package libs;

import org.aeonbits.owner.Config;
/**
*interface for working with hiddenConfig.properties file. login()/password() methods returns hidden data from file
 */

@Config.Sources(value = "file:./src/main/java/resources/hiddenConfig.properties")
public interface ConfigHiddenProperties extends Config {
    String login();
    String password();
}
