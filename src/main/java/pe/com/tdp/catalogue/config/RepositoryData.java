package pe.com.tdp.catalogue.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pe.com.tdp.catalogue.model.Client;
import pe.com.tdp.catalogue.model.Mobile;
import pe.com.tdp.catalogue.model.Ofert;
import pe.com.tdp.catalogue.model.Plan;
import pe.com.tdp.catalogue.repository.ClientRepository;
import pe.com.tdp.catalogue.repository.MobileRepository;
import pe.com.tdp.catalogue.repository.OfertRepository;
import pe.com.tdp.catalogue.repository.PlanRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class RepositoryData implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MobileRepository mobileRepository;
    @Autowired
    private OfertRepository ofertRepository;
    @Autowired
    private PlanRepository planRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        logger.debug("Iniatilize component...");
        sendDatabase();
    }

    private void sendDatabase() {

        // DNI
        clientRepository.save(Client.builder().name("Client Uno").typeDocument("DNI").numberDocument("12345678").build());
        clientRepository.save(Client.builder().name("Client Dos").typeDocument("DNI").numberDocument("12345689").build());

        // Carnet de extranjeria
        clientRepository.save(Client.builder().name("Client Tres").typeDocument("CE").numberDocument("12345678901").build());

        // Ofertas
        ofertRepository.save(Ofert.builder().name("Ofert A").build());
        ofertRepository.save(Ofert.builder().name("Ofert B").build());

        // Planes
        planRepository.save(Plan.builder().name("Plan 29").price(BigDecimal.valueOf(29.90)).build());
        planRepository.save(Plan.builder().name("Plan 39").price(BigDecimal.valueOf(39.90)).build());
        planRepository.save(Plan.builder().name("Plan 49").price(BigDecimal.valueOf(49.90)).build());
        planRepository.save(Plan.builder().name("Plan 65").price(BigDecimal.valueOf(65.90)).build());

        // Moviles
        mobileRepository.save(Mobile.builder()
                .client(clientRepository.findAll().get(0))
                .plan(planRepository.findAll().get(0))
                .oferts(Arrays.asList(ofertRepository.findAll().get(0), ofertRepository.findAll().get(1)))
                .number("948573561")
                .type("Prepago")
                .build()
        );

    }

}
