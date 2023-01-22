package bootcamp.it.exercise.forum.model;

public class User {
    private static int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private Role role;

    public User(int id, String name, String surname, String login, String password, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        User.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Role {
        ADMIN,
        USER,

        MODERATOR
    }

    public static class BudowniczyJOLO {
        User user = new User();

        public BudowniczyJOLO id(int id) {
            this.user.setId(id);
            ;
            return this;
        }

        public BudowniczyJOLO name(String name) {
            this.user.setName(name);
            return this;
        }

        public BudowniczyJOLO surname(String surname) {
            this.user.setSurname(surname);
            return this;
        }

        public BudowniczyJOLO login(String login) {
            this.user.setLogin(login);
            return this;
        }

        public BudowniczyJOLO password(String password) {
            this.user.setPassword(password);
            return this;
        }

        public BudowniczyJOLO role(Role role) {
            this.user.setRole(role);
            return this;
        }
        public User build(){
            return this.user;
        }
        public BudowniczyJOLO clone(User user){
            id(getId())
                    .name(user.getName())
                    .surname(user.getSurname())
                    .login(user.getLogin())
                    .password(user.getPassword())
                    .role(user.getRole());
            return this;
        }


    }

}
