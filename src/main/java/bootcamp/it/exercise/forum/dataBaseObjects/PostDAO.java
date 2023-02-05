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
        postList.add(new Post(1, "Zbigniew Wodecki", "!!!!!!!!!!!**Podwyżki cen komunikacji mejskiej nie dla krakowian***!!!!",
                "Będzie drożej i tyle,kanary dalej chodza i sprawdzją czy masz bilet i wgl i w szczególe.A tak" +
                        " w ogóle to nie lubię tramwajów tzw: akwarium.Ciepło w nich i duszno i wgl człowiek na człowieku" +
                        " i śmierdzi ... tak to już bywa...A wy których tramwajów nie lubicie?"));
        postList.add(new Post(2, "Johny Bravo", "klata jak u pirata", "Ile razy ćwiczycie w tygodniu?"));
        postList.add(new Post(3, "kot Jinks", "Podygfvyvnikacji mejskiej nie dla krakowian", "NIenawidzę ty myszy :P wy też?"));
        postList.add(new Post(4, "Myszka miki", "USZY!?? SERIO??", "czy łądne mam uszy?"));
        postList.add(new Post(5, "kaczor donald", "kwa kwa?", "Mam problem z kwakaniem"));
        postList.add(new Post(6, "kaczor donald", "kwa kwa?", "Mam 0problem z kwakaniem,pomóżcie w końcu"));

    }

    @Override
    public List<Post> getPosts() {
        return postList;
    }

    @Override
    public void addPost(Post post) {
        postList.add(post);
    }

    @Override
    public void editPost(Post post,int oldId) {
        Optional<Post> postById = getPostById(oldId);
        if(postById.isPresent()) {
            post.setId(post.getId());
            post.setHeader(post.getHeader());
            post.setContent(post.getContent());
            post.setAuthor(post.getAuthor());
            postList.set(post.getId(),post);
            postList.remove(postById.get());
        }
    }

    @Override
    public Optional<Post> getPostById(int id) {
        for (Post post : this.postList) {
            if (post.getId() == id) {
                return Optional.of(post);
            }
        }
        return Optional.empty();
    }
}
