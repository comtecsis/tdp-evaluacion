package pe.com.tdp.catalogue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogueApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.debug("Message");
	}
}
