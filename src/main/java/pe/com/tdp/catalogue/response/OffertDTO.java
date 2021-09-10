package pe.com.tdp.catalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pe.com.tdp.catalogue.model.Offert;
import pe.com.tdp.catalogue.utils.TrainingConstants;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@AllArgsConstructor
@Data
@Builder
public class OffertDTO implements Serializable {

    public static long serialVersionUID = TrainingConstants.SERIAL_VERSION;
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

    private Long id;
    private String name;
    private String code;
    private String description;
    private String begin;
    private String end;

    public OffertDTO(Offert offert){
        this(offert.getId(), offert.getName(), offert.getCode(), offert.getDescription(), DATE_FORMATTER.format(offert.getBegin()), DATE_FORMATTER.format(offert.getEnd()));
    }
}
