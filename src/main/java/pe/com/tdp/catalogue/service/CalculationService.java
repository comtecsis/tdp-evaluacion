package pe.com.tdp.catalogue.service;

import pe.com.tdp.catalogue.request.FindClientByTypeDocAndNumDocRequest;
import pe.com.tdp.catalogue.response.ClientDTO;

import java.util.Collection;

public interface CalculationService {
    public double areaOfCircle(int radius);
    public Collection<ClientDTO> findByTypeDocAndNumDoc(FindClientByTypeDocAndNumDocRequest request);
}
