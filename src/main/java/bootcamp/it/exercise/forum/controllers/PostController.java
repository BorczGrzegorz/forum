package bootcamp.it.exercise.forum.controllers;

import bootcamp.it.exercise.forum.dataBaseObjects.IPostDAO;
import bootcamp.it.exercise.forum.model.Post;
import bootcamp.it.exercise.forum.model.User;
import bootcamp.it.exercise.forum.session.SessionObject;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    IPostDAO postDAO;
    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String news(Model model) {
        model.addAttribute("postList", postDAO.getPosts());
        model.addAttribute("sessionObject", this.sessionObject);
        return "posts";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("postList", postDAO.getPosts());
        model.addAttribute("sessionObject", this.sessionObject);
        model.addAttribute("post", new Post());
        return "add";
    }
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addPost(@ModelAttribute Post post){
        post.setId(postDAO.getPosts().size()+1);
        this.postDAO.addPost(post);
        return "redirect:/posts";
    }
    @RequestMapping(path = "/edit/{postId}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int postId) {
        Optional<Post> postById = postDAO.getPostById(postId);
        if (postById.isEmpty()) {
            return "redirect:/posts";
        }
        model.addAttribute("sessionObject", this.sessionObject);
        model.addAttribute("post", postById.get());
        model.addAttribute("postList",postDAO.getPosts());
        return "edit";
    }

}
