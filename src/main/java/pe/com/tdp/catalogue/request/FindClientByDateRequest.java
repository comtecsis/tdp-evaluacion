package pe.com.tdp.catalogue.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.tdp.catalogue.utils.TrainingConstants;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FindClientByDateRequest implements Serializable {

    public static long serialVersionUID = TrainingConstants.SERIAL_VERSION;

    private String beforeDate;

}
