package pe.com.tdp.catalogue.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.print.Book;
import java.sql.Timestamp;
import java.util.List;

@Entity(name="CLIENT")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Client {
    @Id
    @GeneratedValue(generator = "clientGen")
    @Column(name="clientId")
    private Long id;
    private String name;
    @Column(name="type_document")
    private String typeDocument;
    @Column(name="number_document")
    private String numberDocument;
    private Timestamp datebirth;

    @OneToMany(cascade = CascadeType.DETACH, orphanRemoval = false)
    @JoinColumn(name = "clientFk")
    private List<Mobile> mobiles;
}
