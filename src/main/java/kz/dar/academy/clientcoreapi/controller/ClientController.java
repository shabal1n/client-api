package kz.dar.academy.clientcoreapi.controller;

import kz.dar.academy.clientcoreapi.model.ClientRequest;
import kz.dar.academy.clientcoreapi.model.ClientResponse;
import kz.dar.academy.clientcoreapi.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@EnableEurekaClient
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private Environment environment;

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        return new ResponseEntity<>("client-core-api is working at " + environment.getProperty("local.server.port"), HttpStatus.OK);
    }

    @PostMapping
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest) {
        return clientService.createClient(clientRequest);
    }

    @GetMapping("/all")
    public List<ClientResponse> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientResponse getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public ClientResponse updateClientById(@RequestBody ClientRequest clientRequest) {
        return clientService.updateClientById(clientRequest);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable String clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<>("Client was deleted", HttpStatus.OK);
    }
}
