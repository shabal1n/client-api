package kz.dar.academy.postofficeapi.controller;

import kz.dar.academy.postofficeapi.feign.ClientFeign;
import kz.dar.academy.postofficeapi.model.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post-api")
public class ClientController {
    @Autowired
    ClientFeign clientFeign;

    @GetMapping("/client/check")
    public String checkClient() {
        return clientFeign.checkClient();
    }

    @GetMapping("/client/all")
    public List<ClientResponse> getAllClients() {
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    public ClientResponse getClientById(@PathVariable String clientId) {
        return clientFeign.getClientById(clientId);
    }
}
