package bootcamp.it.exercise.forum.controllers;

import bootcamp.it.exercise.forum.dataBaseObjects.IPostDAO;
import bootcamp.it.exercise.forum.model.Post;
import bootcamp.it.exercise.forum.services.IPostDAOService;
import bootcamp.it.exercise.forum.services.IUserDAOService;
import bootcamp.it.exercise.forum.session.SessionObject;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {

    @Resource
    SessionObject sessionObject;
    @Autowired
    IPostDAOService postDAOService;


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String news(Model model) {
        model.addAttribute("postList", postDAOService.getPosts());
        model.addAttribute("sessionObject", this.sessionObject);
        return "posts";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("postList", postDAOService.getPosts());
        model.addAttribute("sessionObject", this.sessionObject);
        model.addAttribute("post", new Post());
        return "add";
    }
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addPost(@ModelAttribute Post post){
        post.setId(postDAOService.getPosts().size()+1);
        this.postDAOService.savePost(post);
        return "redirect:/posts";
    }
    @RequestMapping(path = "/edit/{postId}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int postId) {
        Optional<Post> postById = postDAOService.getPostById(postId);
        if (postById.isEmpty()) {
            return "redirect:/posts";
        }
        model.addAttribute("sessionObject", this.sessionObject);
        model.addAttribute("post", postById.get());
        model.addAttribute("postList",postDAOService.getPosts());
        return "edit";
    }
    @RequestMapping(path = "/edit/{postId}", method = RequestMethod.POST)
    public String edit(@ModelAttribute Post post,
                       @PathVariable int postId) {
        try {
            this.postDAOService.editPost(post, postId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("weszło do catch");
            return "redirect:/edit/post/" + postId;
        }
        return "redirect:/posts";
    }

}
