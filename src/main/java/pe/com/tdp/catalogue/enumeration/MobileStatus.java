package pe.com.tdp.catalogue.enumeration;

import lombok.Getter;

@Getter
public enum MobileStatus {

    ACTIVE("ACTIVO")
    , INACTIVE("INACTIVO");

    private String name;

    MobileStatus(String name){
        this.name = name;
    }
}
