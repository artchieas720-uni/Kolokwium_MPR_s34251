package pl.arturszczepaniak.s34251bank;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BankServiceTest {

    @Test
    void shouldRegisterClient() {

        // GIVEN
        BankStorage storage = new BankStorage();
        BankService service = new BankService(storage);

        // WHEN
        Client client = service.registerClient(
                100
        );

        service.getClient(client.getId());

        // THEN
        Client loaded = service.getClient(client.getId());
        assertEquals(Status.ACCEPTED, loaded.getStatus());
    }
}