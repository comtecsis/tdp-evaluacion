package pe.com.tdp.catalogue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.com.tdp.catalogue.model.Client;
import pe.com.tdp.catalogue.model.Mobile;
import pe.com.tdp.catalogue.model.Ofert;
import pe.com.tdp.catalogue.model.Plan;
import pe.com.tdp.catalogue.repository.ClientRepository;
import pe.com.tdp.catalogue.repository.MobileRepository;
import pe.com.tdp.catalogue.repository.OfertRepository;
import pe.com.tdp.catalogue.repository.PlanRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
@SpringBootApplication
public class CatalogueApplication {

	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);
	}

}
