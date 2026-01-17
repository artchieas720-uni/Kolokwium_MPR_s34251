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
        assertEquals(350.0, loaded.getValueOfMoney());
        assertEquals(loaded.getId(), loaded.getId());
    }


    @Test
    void shouldFailWhenInsufficientFunds() {

        // GIVEN
        Client client = service.registerClient(
0
        );

        service.deposit(client.getId(), 100.0F);

        // WHEN
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> service.transaction(client.getId(), 200.0F)
        );

        // THEN
        assertEquals("Niewystarczające środki", ex.getMessage());
    }


}
