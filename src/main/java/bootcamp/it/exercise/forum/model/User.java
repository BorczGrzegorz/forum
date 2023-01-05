package bootcamp.it.exercise.forum.model;

public class User {
    String name;
    String surname;
    String login;
    String password;
    String password2;


    public User(String name, String surname, String login, String password, String password2) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.password2 = password2;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}