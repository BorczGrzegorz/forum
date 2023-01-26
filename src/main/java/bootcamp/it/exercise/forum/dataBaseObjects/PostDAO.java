package bootcamp.it.exercise.forum.dataBaseObjects;

import bootcamp.it.exercise.forum.sequence.IIdSequence;
import bootcamp.it.exercise.forum.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.ToDoubleBiFunction;

@Repository
public class PostDAO implements IPostDAO {
    @Autowired
    IIdSequence idSequence;


    private final List<Post> postList = new ArrayList<>();

    PostDAO() {
        postList.add(new Post(1, "Michał Kruczała", "Podwyżki cen komunikacji mejskiej nie dla krakowian", "Nie będzie drożej i chuj"));
        postList.add(new Post(2, "Johny Bravo", "klata jak u pirata", "Ile razy ćwiczycie w tygodniu?"));
        postList.add(new Post(3, "kot Jinks", "Podygfvyvnikacji mejskiej nie dla krakowian", "NIenawidzę ty myszy :P wy też?"));
        postList.add(new Post(4, "Myszka miki", "USZY!?? SERIO??", "czy łądne mam uszy?"));
        postList.add(new Post(5, "kaczor donald", "kwa kwa?", ""));
    }

    //idSequence.getPostId()
    @Override
    public List<Post> getPosts() {
        return postList;
    }

    @Override
    public void addPost(Post news) {
        postList.add(news);
    }

    @Override
    public void editPost(Post post) {
       // post.setAuthor();

    }


}
