public class User {
    public String UserId = "2";
    public String UserName = "tt";
    public String Password = "123";
    public String ContactTel = "lalalalaa";
    public String Email = "58315@qq.com";

    public User(String userId, String userName, String password, String contactTel, String email) {
        UserId = userId;
        UserName = userName;
        Password = password;
        ContactTel = contactTel;
        Email = email;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getContactTel() {
        return ContactTel;
    }

    public void setContactTel(String contactTel) {
        ContactTel = contactTel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
