import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Messenger messenger = new Messenger();

        messenger.registerUser("123456789", "User1");
        messenger.registerUser("987654321", "User2");

        System.out.println("Введите номер телефона для входа:");
        String phoneNumber = scanner.nextLine();
        messenger.login(phoneNumber);

        System.out.println("Введите номер телефона получателя:");
        String recipientPhoneNumber = scanner.nextLine();
        System.out.println("Введите текст сообщения:");
        String messageContent = scanner.nextLine();
        messenger.sendMessage(messageContent, recipientPhoneNumber);

        messenger.readMessages();
    }
    }
