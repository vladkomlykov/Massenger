public class MyEncryption implements Encryption{

    @Override
    public String encrypt(String message) {
        return "Encrypted: " + message;
    }

    @Override
    public String decrypt(String encryptedMessage) {
        return encryptedMessage.replace("Encrypted: ", "");
    }

}
