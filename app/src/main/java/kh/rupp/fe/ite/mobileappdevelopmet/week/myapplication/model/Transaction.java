package kh.rupp.fe.ite.mobileappdevelopmet.week.myapplication.model;

public class Transaction {
    private String id;
    private String title;      // e.g., "Amazon"
    private String subtitle;   // e.g., "Today • 12:45 PM"
    private String amount;     // e.g., "- $24.99"
    private String timestamp;  // e.g., ISO date string or display text

    public Transaction() { }

    public Transaction(String id, String title, String subtitle, String amount, String timestamp) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getSubtitle() { return subtitle; }
    public String getAmount() { return amount; }
    public String getTimestamp() { return timestamp; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }
    public void setAmount(String amount) { this.amount = amount; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}