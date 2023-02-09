package bootcamp.it.exercise.forum.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "tuser")
public class User implements Saveable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Post> posts;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Comment> comments;

    private String name;
    private String surname;
    @Column(unique = true)
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(int id, String name, Set<Post> posts, Set<Comment> comments, String surname, String login, String password, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
        this.posts = posts;
        this.comments = comments;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public enum Role {
        ADMIN,
        USER,

        MODERATOR
    }

    public static class BudowniczyUsera {
        User user = new User();

        public BudowniczyUsera id(int id) {
            this.user.setId(id);
            ;
            return this;
        }

        public BudowniczyUsera name(String name) {
            this.user.setName(name);
            return this;
        }

        public BudowniczyUsera surname(String surname) {
            this.user.setSurname(surname);
            return this;
        }

        public BudowniczyUsera login(String login) {
            this.user.setLogin(login);
            return this;
        }

        public BudowniczyUsera password(String password) {
            this.user.setPassword(password);
            return this;
        }

        public BudowniczyUsera role(Role role) {
            this.user.setRole(role);
            return this;
        }

        public User build() {
            return this.user;
        }

        public BudowniczyUsera clone(User user) {
            id(user.getId())
                    .name(user.getName())
                    .surname(user.getSurname())
                    .login(user.getLogin())
                    .password(user.getPassword())
                    .role(user.getRole());
            return this;
        }


    }

}
