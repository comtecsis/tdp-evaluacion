package pe.com.tdp.catalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.tdp.catalogue.model.Plan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlanDTO {
    private Long id;
    private String name;
    private BigDecimal price;

    public PlanDTO(Plan plan) {
        this(plan.getId(), plan.getName(), plan.getPrice());
    }
}
