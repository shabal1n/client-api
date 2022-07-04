package kz.dar.academy.clientcoreapi.controller;

import kz.dar.academy.clientcoreapi.model.ClientModel;
import kz.dar.academy.clientcoreapi.service.ClientService;
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
    public ResponseEntity<String> createClient(@RequestBody ClientModel clientModel) {
        clientService.createClient(clientModel);
        return new ResponseEntity<>("Created new client", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClientById(@PathVariable String clientId, @RequestBody ClientModel clientModel) {
        clientService.updateClientById(clientId, clientModel);
        return new ResponseEntity<>("Client was updated", HttpStatus.OK);
    }
    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable String clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<>("Client was deleted", HttpStatus.OK);
    }
}
