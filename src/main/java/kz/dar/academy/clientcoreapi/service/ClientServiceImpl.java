package kz.dar.academy.clientcoreapi.service;

import kz.dar.academy.clientcoreapi.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    private static final HashMap<String, ClientModel> clients = new HashMap<>();

    static {
        ClientModel client1 = new ClientModel("145", "Vasya",
                "Pupkin", "pupkina@mail.ru");
        ClientModel client2 = new ClientModel("489", "Adele",
                "Lawrence", "adele@mail.ru");
        ClientModel client3 = new ClientModel("678", "Michael",
                "Jackson", "mj@mail.ru");

        clients.put(client1.getClientId(), client1);
        clients.put(client2.getClientId(), client2);
        clients.put(client3.getClientId(), client3);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        clients.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clients.get(clientId);
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        clients.put(clientId, clientModel);
    }

    @Override
    public void deleteClientById(String clientId) {
        clients.remove(clientId);
    }
}
