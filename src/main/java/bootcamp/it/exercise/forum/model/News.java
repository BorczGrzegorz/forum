package bootcamp.it.exercise.forum.model;

public class News {

    String Header;
    String Content;


    public News(String header, String content) {
        Header = header;
        Content = content;
    }

    public News() {
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
