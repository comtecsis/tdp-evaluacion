package pe.com.tdp.catalogue.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name="OFERT")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ofert {
    @Id
    @GeneratedValue(generator = "ofertGen")
    @Column(name="ofertId")
    private Long id;
    private String name;
    private String code;
    private String description;
    private Timestamp begin;
    private Timestamp end;
}
