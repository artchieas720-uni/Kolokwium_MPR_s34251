package pl.arturszczepaniak.s34251bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BankIntegrityTest {


    @Autowired
    private BankService service;

    @Test
    void fullClientFlowTest() {

        // GIVEN
        Client client = service.registerClient(
                0
        );

        // WHEN
        service.deposit(client.getId(), 500.0F);
        service.transaction(client.getId(), 150.0F);
        service.getClient(client.getId());

        // THEN
        Client loaded = service.getClient(client.getId());

        assertEquals(Status.ACCEPTED, loaded.getStatus());
        assertEquals(350.0, loaded.getBalance());
        assertEquals(loaded.getId(), loaded.getId());
    }


    @Test
    void shouldFailWhenNoFunds() {

        // GIVEN
        Client client = service.registerClient(
0
        );

        service.deposit(client.getId(), 100.0F);

        // WHEN

        Transaction trans = service.transaction(client.getId(), 200.0F);

        // THEN
        assertEquals(Status.DECLINED, trans.getStatus());
    }


}
