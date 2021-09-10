package pe.com.tdp.catalogue.response;

import pe.com.tdp.catalogue.utils.TrainingConstants;

import java.io.Serializable;

public class FindByTypeDocAndNumDocResponse implements Serializable {

    public static long serialVersionUID = TrainingConstants.SERIAL_VERSION;

    public ClientDTO client;
}
