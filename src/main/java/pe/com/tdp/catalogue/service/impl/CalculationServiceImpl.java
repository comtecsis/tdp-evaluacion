package pe.com.tdp.catalogue.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.com.tdp.catalogue.enumeration.MobileStatus;
import pe.com.tdp.catalogue.model.Client;
import pe.com.tdp.catalogue.model.Mobile;
import pe.com.tdp.catalogue.model.Offert;
import pe.com.tdp.catalogue.repository.ClientRepository;
import pe.com.tdp.catalogue.repository.OffertRepository;
import pe.com.tdp.catalogue.request.FindClientByDateRequest;
import pe.com.tdp.catalogue.request.FindClientByTypeDocAndNumDocRequest;
import pe.com.tdp.catalogue.response.ClientDTO;
import pe.com.tdp.catalogue.service.CalculationService;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalculationServiceImpl implements CalculationService {

    private static final Logger LOG = LogManager.getLogger();

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OffertRepository offertRepository;

    @Override
    @Cacheable(value = "areaOfCircleCache", key = "#radius", condition = "#radius > 5")
    public double areaOfCircle(int radius) {
        LOG.info("calculate the area of a circle with a radius of {}", radius);
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    @Cacheable(value = "findByTypeDocAndNumDoc", keyGenerator = "customKeyGenerator", unless = "#result.size()==1")
    public List<ClientDTO> findByTypeDocAndNumDoc(FindClientByTypeDocAndNumDocRequest request) {
        LOG.info("Find Client by Type Doc and Number Document of {}", request.toString());
        Collection<Client> clients = clientRepository.findByTypeDocumentAndNumberDocument(request.getTypeDoc(), request.getNumDoc());
        return clients.stream()
            .map(ClientDTO::new)
            .collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> findByDateRequest(FindClientByDateRequest request) {

        Collection<Client> clients = clientRepository.findAll();
        Collection<Offert> offerts = offertRepository.findAll();

        List<Offert> byEndings = offerts.stream()
                .filter(offert -> Timestamp.valueOf(request.getBeforeDate()).before(offert.getEnd()))
                .sorted(Comparator.comparing(Offert::getEnd))
                .collect(Collectors.toList());

        Offert byEnding;
        if(byEndings.isEmpty())
        {
            return Collections.<ClientDTO>emptyList();
        }
        else
        {
            byEnding = byEndings.get(0);
        }
        List<ClientDTO> clientsDTO = clients.stream()
            // Mas de 3 lineas mobiles activas
            .filter(
                client -> client.getMobiles()
                    .stream().filter(mobile ->
                                MobileStatus.ACTIVE.getName().equals(mobile.getState()))
                                    .collect(Collectors.toList()).size() >= 3
            )
            // Mas de una oferta asignada y tienen asignados la oferta proxima a vencer
            .filter(client -> client.getMobiles().stream()
                .anyMatch(
                    mobile -> mobile.getOfferts().size() > 0
                                && mobile.getOfferts().stream()
                                        .anyMatch(offert -> offert.getId() == byEnding.getId())
                )
            )
            // Dejar solo la oferta mas proxima.
            .map(client -> {
                List<Mobile> mobiles = client.getMobiles();
                mobiles.forEach(mobile -> {
                    mobile.setOfferts(mobile.getOfferts().stream().filter(offert -> offert.getId() == byEnding.getId()).collect(Collectors.toList()));
                });
                client.setMobiles(mobiles.stream().filter(mobile -> !mobile.getOfferts().isEmpty()).collect(Collectors.toList()));
                return client;
            })
            .map(ClientDTO::new)
            .collect(Collectors.toList());

        return clientsDTO;
    }
}
