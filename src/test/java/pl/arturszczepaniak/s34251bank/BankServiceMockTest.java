package pl.arturszczepaniak.s34251bank;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

public class BankServiceMockTest {

    @Test
    void shouldDepositMoneyWithMock() {

        // GIVEN
        BankStorage storage = Mockito.mock(BankStorage.class);
        BankService service = new BankService(storage);

        int clientId = (int) Math.random();

        Client client = new Client(
                100.0F,
                Status.ACCEPTED,
                clientId
        );

        Mockito.when(storage.getClientById(clientId))
                .thenReturn(Optional.of(client));

        // WHEN
        service.deposit(clientId, 50.0F);

        // THEN
        assertEquals(150.0, client.getValueOfMoney());
    }

    @Test
    void shouldNotCanPayMock() {

        // GIVEN
        BankStorage storage = Mockito.mock(BankStorage.class);
        BankService service = new BankService(storage);

        int clientId = (int) Math.random();

        Client client = new Client(
                100.0F,
                Status.ACCEPTED,
                clientId
        );

        Mockito.when(storage.getClientById(clientId))
                .thenReturn(Optional.of(client));

        // WHEN
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> service.transaction(client.getId(), 200.0F)
        );

        //THEN
        assertEquals("Niewystarczające środki", ex.getMessage());

    }

}
