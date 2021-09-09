package pe.com.tdp.catalogue.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.com.tdp.catalogue.service.CalculationService;

@Service
public class CalculationServiceImpl implements CalculationService {

    private static final Logger LOG = LogManager.getLogger();

    @Override
    @Cacheable(value = "areaOfCircleCache", key = "#radius", condition = "#radius > 5")
    public double areaOfCircle(int radius) {
        LOG.info("calculate the area of a circle with a radius of {}", radius);
        return Math.PI * Math.pow(radius, 2);
    }
}
