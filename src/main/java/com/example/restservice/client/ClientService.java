package com.example.restservice.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;

// Service layer contains all the Business logic

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found"));
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public ResponseEntity<Client> createClient(Client client) throws URISyntaxException {
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
    }

    @Transactional
    public ResponseEntity<Client> updateClient(Long id, Client client) {
        Client currentClient = clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found"));

        currentClient.setName(client.getName());
        currentClient.setEmail(client.getEmail());

        return ResponseEntity.ok(currentClient);
    }

    @Transactional
    public ResponseEntity<Void> deleteClient(Long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
