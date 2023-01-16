package bootcamp.it.exercise.forum.model;

public class Post {

    String Header;
    String Content;


    public Post(String header, String content) {
        Header = header;
        Content = content;
    }

    public Post() {
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }


}
