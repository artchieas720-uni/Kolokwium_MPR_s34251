package pl.arturszczepaniak.s34251bank;

public class Transaction {
    private Status status;
    private float value;
    private int clientId;

    public Transaction(Status status, float value, int clientId) {
        this.status = status;
        this.value = value;
        this.clientId = clientId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
