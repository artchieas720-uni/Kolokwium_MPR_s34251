package pl.arturszczepaniak.s34251bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class BankStorage {

    public ArrayList<Client> clients = new ArrayList<Client>();


    private int IdOfTicket = 1;

    public Client save(Client client ) {
        client.setId(IdOfTicket++);
        clients.add(client);
        return client;
    }

    public ArrayList<Client> getALLClients() {
        return clients;
    }

    public Optional<Client> getClientById(int id) {
        return clients.stream()
                .filter(ticket -> ticket.getId() == id)
                .findFirst();
    }


}
