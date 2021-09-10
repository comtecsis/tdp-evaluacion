package pe.com.tdp.catalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.tdp.catalogue.model.Mobile;
import pe.com.tdp.catalogue.utils.TrainingConstants;

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

    private List<OffertDTO> oferts;

    public MobileDTO(Mobile mobile) {
        this.id = mobile.getId();
        this.number = mobile.getNumber();
        this.state = mobile.getState();
        this.type = mobile.getType();
        this.oferts = mobile.getOfferts().stream().map(OffertDTO::new).collect(Collectors.toList());
        if(mobile.getPlan() != null)
        {
            this.plan = new PlanDTO(mobile.getPlan());
        }
    }
}
