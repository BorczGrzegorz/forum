package bootcamp.it.exercise.forum.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "tPost")
public class Post implements Saveable{
    private String header;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> comments;
    private String content;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;


    public Post(int id, String author, String header, String content, Set<Comment> comments) {
        this.author = author;
        this.id = id;
        this.header = header;
        this.content = content;
        this.comments = comments;
    }

    public Post() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}










