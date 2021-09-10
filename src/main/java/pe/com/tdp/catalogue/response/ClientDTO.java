package pe.com.tdp.catalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pe.com.tdp.catalogue.model.Client;
import pe.com.tdp.catalogue.model.Mobile;
import pe.com.tdp.catalogue.utils.TrainingConstants;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@Builder
public class ClientDTO implements Serializable {

    public static long serialVersionUID = TrainingConstants.SERIAL_VERSION;

    public ClientDTO(Client client)
    {
        this(client.getId(), client.getName(), client.getTypeDocument(), client.getNumberDocument(), client.getDatebirth(), client.getMobiles().stream().map(MobileDTO::new).collect(Collectors.toList()));
    }

    private Long id;
    private String name;
    private String typeDocument;
    private String numberDocument;
    private Timestamp datebirth;

    private List<MobileDTO> mobiles;

}
