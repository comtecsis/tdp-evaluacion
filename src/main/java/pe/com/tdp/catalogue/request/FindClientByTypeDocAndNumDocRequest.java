package pe.com.tdp.catalogue.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.tdp.catalogue.utils.TrainingConstants;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FindClientByTypeDocAndNumDocRequest implements Serializable {

    public static long serialVersionUID = TrainingConstants.SERIAL_VERSION;

    private String typeDoc;
    private String numDoc;
}
