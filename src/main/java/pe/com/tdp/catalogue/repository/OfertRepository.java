package pe.com.tdp.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.tdp.catalogue.model.Mobile;
import pe.com.tdp.catalogue.model.Ofert;

@Repository
public interface OfertRepository extends JpaRepository<Ofert, Long> {
}
