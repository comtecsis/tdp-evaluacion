package pe.com.tdp.catalogue.enumeration;

import lombok.Getter;

@Getter
public enum PlanEnum {

    PREPAGO("PREPAGO")
    , POSTPAGO("POSTPAGO");

    private String name;

    PlanEnum(String name){
        this.name = name;
    }

}
