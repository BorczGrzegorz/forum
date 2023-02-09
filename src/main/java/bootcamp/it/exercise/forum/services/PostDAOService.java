package bootcamp.it.exercise.forum.services;

import bootcamp.it.exercise.forum.dataBaseObjects.IPostDAO;
import bootcamp.it.exercise.forum.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostDAOService implements IPostDAOService {
    @Autowired
    IPostDAO postDAO;

    @Override
    public List<Post> getPosts() {
        return this.postDAO.getPosts();
    }
    @Override
    public void savePost(Post post) {
        this.postDAO.savePost(post);

    }
    @Override
    public void editPost(Post post, int oldID) {
        post.setId(oldID);
        this.postDAO.editPost(post);
    }
    @Override
    public Optional<Post> getPostById(int id) {
        return this.postDAO.getPostById(id);
    }
}
