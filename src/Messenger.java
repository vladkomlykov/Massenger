import java.util.ArrayList;
import java.util.List;

public class Messenger {
    private List<User> users;
    private List<Message> messages;
    private User currentUser;
    private Encryption encryption;

    public Messenger() {
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.encryption = new MyEncryption();
    }

    public void registerUser(String phoneNumber, String nickName) {
        users.add(new User(phoneNumber, nickName));
        System.out.println("Пользователь " + nickName + " успешно зарегистрирован.");
    }

    public void login(String phoneNumber) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                currentUser = user;
                System.out.println("Вход в мессенджер успешно выполнен для пользователя " + currentUser.getNickName());
                return;
            }
        }
        System.out.println("Пользователь с указанным номером телефона не найден.");
    }

    public void sendMessage(String content, String recipientPhoneNumber) {
        if (currentUser == null) {
            System.out.println("Вы не вошли в мессенджер. Пожалуйста, войдите сначала.");
            return;
        }

        User recipient = findUserByPhoneNumber(recipientPhoneNumber);
        if (recipient != null) {
            String encryptedContent = encryption.encrypt(content);
            Message message = new Message(encryptedContent, currentUser.getPhoneNumber(), recipient.getPhoneNumber(), true);
            messages.add(message);
            System.out.println("Сообщение успешно отправлено.");
        } else {
            System.out.println("Получатель с указанным номером телефона не найден.");
        }
    }

    public void readMessages() {
        if (currentUser == null) {
            System.out.println("Вы не вошли в мессенджер. Пожалуйста, войдите сначала.");
            return;
        }

        System.out.println("Ваши сообщения:");

        for (Message message : messages) {
            if (message.getRecipient().equals(currentUser.getPhoneNumber())) {
                String decryptedContent = encryption.decrypt(message.getContent());
                System.out.println("Отправитель: " + message.getSender() + ", Сообщение: " + decryptedContent);
            }
        }
    }

    private User findUserByPhoneNumber(String phoneNumber) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }
}
