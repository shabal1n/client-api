package kz.dar.academy.clientcoreapi.service.client;

import kz.dar.academy.clientcoreapi.model.ClientRequest;
import kz.dar.academy.clientcoreapi.model.ClientResponse;

import java.util.List;

public interface ClientService {

    ClientResponse createClient(ClientRequest clientRequest);

    List<ClientResponse> getAllClients();

    ClientResponse getClientById(String clientId);

    ClientResponse updateClientById(ClientRequest clientRequest);

    void deleteClientById(String clientId);
}
