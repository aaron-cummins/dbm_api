package cl.cummins.dbm;

import cl.cummins.dbm.util.DbmProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DbmProperties.class)
public class DbmApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbmApplication.class, args);
	}

}
