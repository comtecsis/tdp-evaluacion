package pe.com.tdp.catalogue.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.print.Book;
import java.sql.Timestamp;
import java.util.List;

@Entity(name="MOBILE")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Mobile {
    @Id
    @GeneratedValue(generator = "mobileGen")
    @Column(name="mobileId")
    private Long id;
    private String number;
    private String state;
    private String type;

    @OneToOne(cascade = CascadeType.DETACH, orphanRemoval = false)
    @JoinColumn(name = "planFk")
    private Plan plan;

    @OneToOne(cascade = CascadeType.DETACH, orphanRemoval = false)
    @JoinColumn(name = "clientFk")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "mobile_ofert",
            joinColumns = @JoinColumn(name = "ofertFk"),
            inverseJoinColumns = @JoinColumn(name = "mobileFk"))
    private List<Ofert> oferts;

}
