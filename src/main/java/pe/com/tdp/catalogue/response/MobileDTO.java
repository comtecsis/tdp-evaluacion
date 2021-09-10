package pe.com.tdp.catalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.tdp.catalogue.model.Client;
import pe.com.tdp.catalogue.model.Mobile;
import pe.com.tdp.catalogue.model.Ofert;
import pe.com.tdp.catalogue.model.Plan;
import pe.com.tdp.catalogue.utils.TrainingConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MobileDTO implements Serializable {

    public static long serialVersionUID = TrainingConstants.SERIAL_VERSION;

    private Long id;
    private String number;
    private String state;
    private String type;

    private PlanDTO plan;

    private List<OfertDTO> oferts;

    public MobileDTO(Mobile mobile) {
        this(mobile.getId(), mobile.getNumber(), mobile.getState(), mobile.getType(), new PlanDTO(mobile.getPlan()), mobile.getOferts().stream().map(OfertDTO::new).collect(Collectors.toList()));
    }
}
