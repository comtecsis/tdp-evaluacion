package pe.com.tdp.catalogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.tdp.catalogue.enumeration.TrainingStatusEnum;
import pe.com.tdp.catalogue.request.CalculationRequest;
import pe.com.tdp.catalogue.request.FindClientByDateRequest;
import pe.com.tdp.catalogue.request.FindClientByTypeDocAndNumDocRequest;
import pe.com.tdp.catalogue.response.ClientDTO;
import pe.com.tdp.catalogue.response.TrainingResponse;
import pe.com.tdp.catalogue.service.CalculationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private static Logger LOG = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private CalculationService service;

    @PostMapping("/calculation")
    public ResponseEntity<?> calculation(@RequestBody CalculationRequest bean, HttpServletRequest request) {
        double result = service.areaOfCircle(bean.getRadius());
        return ResponseEntity.ok().body(new TrainingResponse<Double>(TrainingStatusEnum.OK.getStatus(), result));
    }

    @PostMapping("/findByTypeDocAndNumDoc")
    public ResponseEntity<?> findClientOne(@RequestBody FindClientByTypeDocAndNumDocRequest bean, HttpServletRequest request) {
        Collection<ClientDTO> result = service.findByTypeDocAndNumDoc(bean);
        return ResponseEntity.ok().body(new TrainingResponse<Collection<ClientDTO>>(TrainingStatusEnum.OK.getStatus(), result));
    }

    @PostMapping("/findByDate")
    public ResponseEntity<?> findByDate(@RequestBody FindClientByDateRequest bean, HttpServletRequest request) {
        Collection<ClientDTO> result = service.findByDateRequest(bean);
        return ResponseEntity.ok().body(new TrainingResponse<Collection<ClientDTO>>(TrainingStatusEnum.OK.getStatus(), result));
    }




}
