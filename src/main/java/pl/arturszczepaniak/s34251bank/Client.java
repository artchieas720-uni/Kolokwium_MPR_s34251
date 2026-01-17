package pl.arturszczepaniak.s34251bank;

public class Client {
    private int id;
    private Status status;
    private float balance;

    public Client(float valueOfMoney, Status status, int id) {
        this.balance = valueOfMoney;
        this.status = status;
        this.id = id;
    }

    public Client(float valueOfMoney, Status status) {
        this.balance = valueOfMoney;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
