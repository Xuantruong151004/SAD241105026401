package Model;

public class Transaction {
    private String description;
    private double amount;
    private String date;
    private String type;
    // Constructor
    public Transaction(String description, double amount, String date,String type) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type=type;
    }

    // Getters và Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
