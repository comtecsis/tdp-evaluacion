package pe.com.tdp.catalogue.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pe.com.tdp.catalogue.enumeration.MobileStatus;
import pe.com.tdp.catalogue.enumeration.PlanEnum;
import pe.com.tdp.catalogue.model.Client;
import pe.com.tdp.catalogue.model.Mobile;
import pe.com.tdp.catalogue.model.Offert;
import pe.com.tdp.catalogue.model.Plan;
import pe.com.tdp.catalogue.repository.ClientRepository;
import pe.com.tdp.catalogue.repository.MobileRepository;
import pe.com.tdp.catalogue.repository.OffertRepository;
import pe.com.tdp.catalogue.repository.PlanRepository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

@Component
public class RepositoryData implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MobileRepository mobileRepository;
    @Autowired
    private OffertRepository offertRepository;
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
        clientRepository.save(Client.builder().name("Client Tres").typeDocument("DNI").numberDocument("12345690").build());
        clientRepository.save(Client.builder().name("Client Cuatro").typeDocument("DNI").numberDocument("12345691").build());
        clientRepository.save(Client.builder().name("Client Cinco").typeDocument("CE").numberDocument("12345689111").build());
        clientRepository.save(Client.builder().name("Client Seis").typeDocument("CE").numberDocument("12345689222").build());

        // Carnet de extranjeria
        clientRepository.save(Client.builder().name("Client Tres").typeDocument("CE").numberDocument("12345678901").build());

        // Ofertas
        offertRepository.save(Offert.builder().name("Ofert A").begin(Timestamp.valueOf("2021-09-01 00:00:00.0")).end(Timestamp.valueOf("2021-09-12 00:00:00.0")).build());
        offertRepository.save(Offert.builder().name("Ofert B").begin(Timestamp.valueOf("2021-09-01 00:00:00.0")).end(Timestamp.valueOf("2021-09-13 00:00:00.0")).build());
        offertRepository.save(Offert.builder().name("Ofert C").begin(Timestamp.valueOf("2021-09-01 00:00:00.0")).end(Timestamp.valueOf("2021-09-14 00:00:00.0")).build());
        offertRepository.save(Offert.builder().name("Ofert D").begin(Timestamp.valueOf("2021-09-01 00:00:00.0")).end(Timestamp.valueOf("2021-09-15 00:00:00.0")).build());
        offertRepository.save(Offert.builder().name("Ofert E").begin(Timestamp.valueOf("2021-09-01 00:00:00.0")).end(Timestamp.valueOf("2021-09-16 00:00:00.0")).build());

        // Planes
        planRepository.save(Plan.builder().name("Plan 29").price(BigDecimal.valueOf(29.90)).build());
        planRepository.save(Plan.builder().name("Plan 39").price(BigDecimal.valueOf(39.90)).build());
        planRepository.save(Plan.builder().name("Plan 49").price(BigDecimal.valueOf(49.90)).build());
        planRepository.save(Plan.builder().name("Plan 65").price(BigDecimal.valueOf(65.90)).build());

        // Moviles

        // Con plan y dos ofertas asignadas | DNI | 12345689
        mobileRepository.save(Mobile.builder()
                .client(clientRepository.findByTypeDocumentAndNumberDocument("DNI", "12345689").get(0))
                .plan(planRepository.findAll().get(0))
                .offerts(Arrays.asList(offertRepository.findAll().get(0), offertRepository.findAll().get(1)))
                .number("948573560")
                .state(MobileStatus.ACTIVE.getName())
                .type(PlanEnum.PREPAGO.getName())
                .build()
        );

        // Sin plan y una ofertas asignadas | DNI | 12345689
        mobileRepository.save(Mobile.builder()
                .client(clientRepository.findByTypeDocumentAndNumberDocument("DNI", "12345689").get(0))
                .offerts(Arrays.asList(offertRepository.findAll().get(2)))
                .number("948573561")
                .state(MobileStatus.ACTIVE.getName())
                .type(PlanEnum.POSTPAGO.getName())
                .build()
        );

        // Con plan y una oferta asignada | DNI | 12345689
        mobileRepository.save(Mobile.builder()
                .client(clientRepository.findByTypeDocumentAndNumberDocument("DNI", "12345689").get(0))
                .plan(planRepository.findAll().get(0))
                .offerts(Arrays.asList(offertRepository.findAll().get(3)))
                .number("948573562")
                .state(MobileStatus.ACTIVE.getName())
                .type(PlanEnum.PREPAGO.getName())
                .build()
        );

        // Con plan y una ofertas asignadas | DNI | 12345689
        mobileRepository.save(Mobile.builder()
                .client(clientRepository.findByTypeDocumentAndNumberDocument("DNI", "12345689").get(0))
                .offerts(Arrays.asList(offertRepository.findAll().get(2)))
                .plan(planRepository.findAll().get(1))
                .number("948573561")
                .state(MobileStatus.ACTIVE.getName())
                .type(PlanEnum.POSTPAGO.getName())
                .build()
        );

        // Con plan y una oferta asignada | CE | 12345689111
        mobileRepository.save(Mobile.builder()
                .client(clientRepository.findByTypeDocumentAndNumberDocument("CE", "12345689111").get(0))
                .plan(planRepository.findAll().get(0))
                .offerts(Arrays.asList(offertRepository.findAll().get(3), offertRepository.findAll().get(1)))
                .number("948573566")
                .state(MobileStatus.ACTIVE.getName())
                .type(PlanEnum.PREPAGO.getName())
                .build()
        );
        mobileRepository.save(Mobile.builder()
                .client(clientRepository.findByTypeDocumentAndNumberDocument("CE", "12345689111").get(0))
                .plan(planRepository.findAll().get(0))
                .offerts(Arrays.asList(offertRepository.findAll().get(3)))
                .number("948573564")
                .state(MobileStatus.ACTIVE.getName())
                .type(PlanEnum.PREPAGO.getName())
                .build()
        );
        mobileRepository.save(Mobile.builder()
                .client(clientRepository.findByTypeDocumentAndNumberDocument("CE", "12345689111").get(0))
                .plan(planRepository.findAll().get(0))
                .offerts(Arrays.asList(offertRepository.findAll().get(4), offertRepository.findAll().get(2)))
                .number("948573565")
                .state(MobileStatus.ACTIVE.getName())
                .type(PlanEnum.PREPAGO.getName())
                .build()
        );

    }

}
