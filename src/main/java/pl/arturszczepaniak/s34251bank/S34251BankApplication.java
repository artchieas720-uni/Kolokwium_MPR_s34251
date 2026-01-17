package pl.arturszczepaniak.s34251bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S34251BankApplication {

    private final BankService bankService;

    public S34251BankApplication(BankService rentalService)
    {
        this.bankService = rentalService;
    }

    public static void main(String[] args) {
        SpringApplication.run(S34251BankApplication.class, args);
    }

}
