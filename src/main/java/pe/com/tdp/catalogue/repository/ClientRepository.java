package pe.com.tdp.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.tdp.catalogue.model.Client;

import java.util.Collection;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Collection<Client> findByTypeDocumentAndNumberDocument(String typeDoc, String numDoc);

}
