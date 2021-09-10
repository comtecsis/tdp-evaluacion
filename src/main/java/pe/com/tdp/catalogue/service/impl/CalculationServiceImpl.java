package pe.com.tdp.catalogue.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.com.tdp.catalogue.model.Client;
import pe.com.tdp.catalogue.repository.ClientRepository;
import pe.com.tdp.catalogue.request.FindClientByTypeDocAndNumDocRequest;
import pe.com.tdp.catalogue.response.ClientDTO;
import pe.com.tdp.catalogue.service.CalculationService;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CalculationServiceImpl implements CalculationService {

    private static final Logger LOG = LogManager.getLogger();

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Cacheable(value = "areaOfCircleCache", key = "#radius", condition = "#radius > 5")
    public double areaOfCircle(int radius) {
        LOG.info("calculate the area of a circle with a radius of {}", radius);
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    @Cacheable(value = "findByTypeDocAndNumDoc", keyGenerator = "customKeyGenerator", unless = "#result.size()==1")
    public Collection<ClientDTO> findByTypeDocAndNumDoc(FindClientByTypeDocAndNumDocRequest request) {
        LOG.info("Find Client by Type Doc and Number Document of {}", request.toString());
        Collection<Client> clients = clientRepository.findByTypeDocumentAndNumberDocument(request.getTypeDoc(), request.getNumDoc());
        return clients.stream()
            .map(ClientDTO::new)
            .collect(Collectors.toList());
    }
}
