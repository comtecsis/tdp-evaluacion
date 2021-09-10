package pe.com.tdp.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.tdp.catalogue.model.Offert;

@Repository
public interface OffertRepository extends JpaRepository<Offert, Long> {
}
