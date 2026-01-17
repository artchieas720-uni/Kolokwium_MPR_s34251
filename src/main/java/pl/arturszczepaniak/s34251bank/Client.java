package pl.arturszczepaniak.s34251bank;

public class Client {
    private int id;
    private Status status;
    private float valueOfMoney;

    public Client(float valueOfMoney, Status status, int id) {
        this.valueOfMoney = valueOfMoney;
        this.status = status;
        this.id = id;
    }

    public Client(float valueOfMoney, Status status) {
        this.valueOfMoney = valueOfMoney;
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

    public float getValueOfMoney() {
        return valueOfMoney;
    }

    public void setValueOfMoney(float valueOfMoney) {
        this.valueOfMoney = valueOfMoney;
    }
}
