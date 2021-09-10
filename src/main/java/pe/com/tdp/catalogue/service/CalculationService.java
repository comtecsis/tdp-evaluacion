package pe.com.tdp.catalogue.service;

import pe.com.tdp.catalogue.request.FindClientByDateRequest;
import pe.com.tdp.catalogue.request.FindClientByTypeDocAndNumDocRequest;
import pe.com.tdp.catalogue.response.ClientDTO;

import java.util.List;

public interface CalculationService {
    public double areaOfCircle(int radius);
    public List<ClientDTO> findByTypeDocAndNumDoc(FindClientByTypeDocAndNumDocRequest request);
    public List<ClientDTO> findByDateRequest(FindClientByDateRequest request);
}
