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


//    public Transaction transaction(int clientId, float val){
//
//        Client client = storage.getClientById(clientId).
//                orElseThrow(() -> new RuntimeException("Client not found"));
//        float transVal = client.getValueOfMoney() - val;
//
//        return new Transaction(StatusOfTransaction.ACCEPTED,transVal,clientId);
//    }
//
//    public void putMoney(int clientId, float val){
//        Client client = storage.getClientById(clientId).
//                orElseThrow(() -> new RuntimeException("Client not found"));
//        float transVal = client.getValueOfMoney() - val;
//        return StatusOfTransaction,transVal
//    }

    public Transaction transaction(int clientId, float amount) {
        Client client = storage.getClientById(clientId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono klienta"));

        if (client.getValueOfMoney() < amount) {
            throw new RuntimeException("Niewystarczające środki");
        }

        client.setValueOfMoney(client.getValueOfMoney() - amount);
        float val = client.getValueOfMoney() - amount;
        return new Transaction(Status.ACCEPTED,val, clientId);
    }

    public Transaction deposit(int clientId, float amount) {
        Client client = storage.getClientById(clientId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono klienta"));

        client.setValueOfMoney(client.getValueOfMoney() + amount);
        float val = client.getValueOfMoney() + amount;
        return new Transaction(Status.ACCEPTED, val, clientId);
    }

    public Client getClient(int clientId) {
        return storage.getClientById(clientId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono klienta"));
    }

}
