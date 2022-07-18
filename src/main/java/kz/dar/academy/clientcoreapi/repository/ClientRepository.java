package kz.dar.academy.clientcoreapi.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

    ClientEntity getClientEntityByClientId(String clientId);

    List<ClientEntity> getClientEntitiesBy();

    void deleteClientEntityByClientId(String clientId);
}
