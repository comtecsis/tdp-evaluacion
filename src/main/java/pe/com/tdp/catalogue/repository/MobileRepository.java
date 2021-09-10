package pe.com.tdp.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.tdp.catalogue.model.Client;
import pe.com.tdp.catalogue.model.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
}
