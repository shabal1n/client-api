package kz.dar.academy.clientcoreapi.service.client;

import kz.dar.academy.clientcoreapi.model.ClientRequest;
import kz.dar.academy.clientcoreapi.model.ClientResponse;
import kz.dar.academy.clientcoreapi.repository.ClientEntity;
import kz.dar.academy.clientcoreapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        clientRequest.setClientId(UUID.randomUUID().toString());
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        clientRepository.save(clientEntity);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        return clientRepository.getClientEntitiesBy().stream()
                .map(client -> modelMapper.map(client, ClientResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse getClientById(String clientId) {
        ClientEntity clientEntity = clientRepository.getClientEntityByClientId(clientId);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public ClientResponse updateClientById(ClientRequest clientRequest) {
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        ClientEntity dbEntity = clientRepository.getClientEntityByClientId(clientEntity.getClientId());
        clientEntity.setId(dbEntity.getId());

        clientRepository.save(clientEntity);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientRepository.deleteClientEntityByClientId(clientId);
    }
}
