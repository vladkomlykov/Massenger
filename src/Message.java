public class Message {
    private String content;
    private String sender;
    private String recipient;
    private boolean encrypted;

    public Message(String content, String sender, String recipient, boolean encrypted) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
        this.encrypted = encrypted;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }
}
