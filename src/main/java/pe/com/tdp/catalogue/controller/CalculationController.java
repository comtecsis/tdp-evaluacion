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
import pe.com.tdp.catalogue.response.TrainingResponse;
import pe.com.tdp.catalogue.service.CalculationService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/calculation")
public class CalculationController {

    private static Logger LOG = LoggerFactory.getLogger(CalculationController.class);

    @Autowired
    private CalculationService service;

    @PostMapping("")
    public ResponseEntity<?> calculation(@RequestBody CalculationRequest bean, HttpServletRequest request) {
        double result = service.areaOfCircle(bean.getRadius());
        return ResponseEntity.ok().body(new TrainingResponse<Double>(TrainingStatusEnum.OK.getStatus(), result));
    }


}
