package pe.com.tdp.catalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pe.com.tdp.catalogue.utils.TrainingConstants;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class TrainingResponse <T> implements Serializable {

    public static long serialVersionUID = TrainingConstants.SERIAL_VERSION;

    private TrainingStatus status;
    private T data;

    public TrainingResponse(TrainingStatus status){
        this.status = status;
    }

}
