package bootcamp.it.exercise.forum.model;

public class Post {
    private String header;
    private String content;
    private int id;
    private String author;


    public Post(int id, String author, String header, String content) {//, Comment comment) {
        this.author = author;
        this.id = id;
        this.header = header;
        this.content = content;
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
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
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
}
