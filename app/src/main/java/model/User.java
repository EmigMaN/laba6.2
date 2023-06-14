package model;

public class User {

    private String login;
    private String pass;
    private String email;

    public User(String log, String pass, String mail)
    {
        login = log;
        this.pass = pass;
        email = mail;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

}
