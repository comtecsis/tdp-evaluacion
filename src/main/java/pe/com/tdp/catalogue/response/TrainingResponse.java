package pe.com.tdp.catalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TrainingResponse <T> {

    private TrainingStatus status;
    private T data;

    public TrainingResponse(TrainingStatus status){
        this.status = status;
    }

}
