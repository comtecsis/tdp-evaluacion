package pe.com.tdp.catalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pe.com.tdp.catalogue.model.Ofert;
import pe.com.tdp.catalogue.utils.TrainingConstants;

import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@Data
@Builder
public class OfertDTO implements Serializable {

    public static long serialVersionUID = TrainingConstants.SERIAL_VERSION;

    private Long id;
    private String name;
    private String code;
    private String description;
    private Timestamp begin;
    private Timestamp end;

    public OfertDTO(Ofert ofert){
        this(ofert.getId(), ofert.getName(), ofert.getCode(), ofert.getDescription(), ofert.getBegin(), ofert.getEnd());
    }
}
