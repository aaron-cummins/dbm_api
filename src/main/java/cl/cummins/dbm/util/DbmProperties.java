package cl.cummins.dbm.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dbm")
public record DbmProperties(String keystorePath, String keystorePassword, String keystoreKeyAlias, String keystorePrivateKeyPassphrase) {

}
