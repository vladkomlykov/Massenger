public class User {
    private String phoneNumber;
    private String nickName;

    public User(String phoneNumber, String nickName) {
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNickName() {
        return nickName;
    }
}
