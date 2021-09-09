package pe.com.tdp.catalogue.enumeration;

import lombok.Getter;
import pe.com.tdp.catalogue.response.TrainingStatus;

@Getter
public enum TrainingStatusEnum {

    OK("0000", "Proceso exitoso.")
    , FAIL("9000", "Proceso con errores.");

    private TrainingStatus status;

    TrainingStatusEnum(String code, String message){
        status = new TrainingStatus(code, message);
    }

}
