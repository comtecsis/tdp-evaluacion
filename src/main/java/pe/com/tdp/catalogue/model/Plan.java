package pe.com.tdp.catalogue.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name="PLAN")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Plan {
    @Id
    @GeneratedValue(generator = "planGen")
    @Column(name="planId")
    private Long id;
    private String name;
    private BigDecimal price;
}
