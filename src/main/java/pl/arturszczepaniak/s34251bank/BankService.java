package pl.arturszczepaniak.s34251bank;

import org.springframework.stereotype.Service;

@Service
public class BankService {

    private final BankStorage storage;

    public BankService(BankStorage storage) {
        this.storage = storage;
    }

    public Client registerClient(int valueOfClientAcc) {
        Client client = new Client(valueOfClientAcc,
                Status.PENDING
        );
        client.setStatus(Status.ACCEPTED);
        return storage.save(client);
    }

    public Transaction transaction(int clientId, float amount) {
        Client client = storage.getClientById(clientId).get();

        if(client == null){
            return new Transaction(Status.DECLINED, amount, clientId);
        }

        float val = client.getBalance() - amount;
        if (client.getBalance() < amount) {
            return new Transaction(Status.DECLINED, amount, clientId);
        }

        client.setBalance(client.getBalance() - amount);
        return new Transaction(Status.ACCEPTED,val, clientId);
    }

    public Transaction deposit(int clientId, float amount) {

        Client client = storage.getClientById(clientId).get();

        if(client == null){
            return new Transaction(Status.DECLINED, amount, clientId);
        }

        client.setBalance(client.getBalance() + amount);
        float val = client.getBalance() + amount;
        return new Transaction(Status.ACCEPTED, val, clientId);
    }

    public Client getClient(int clientId) {
        return storage.getClientById(clientId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono klienta"));
    }

}
