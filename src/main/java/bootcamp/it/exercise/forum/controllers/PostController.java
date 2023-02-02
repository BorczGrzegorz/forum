package bootcamp.it.exercise.forum.controllers;

import bootcamp.it.exercise.forum.dataBaseObjects.IPostDAO;
import bootcamp.it.exercise.forum.model.Post;
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
        // model.addAttribute("sessionObject.isModerator()",sessionObject.isModerator());
        return "posts";
    }

    //////////////////////////////////////////////////////////////
    @RequestMapping(path = "/post/edit/{postId}", method = RequestMethod.GET)
    public String editPost(@PathVariable int postId, Model model) {
        Optional<Post> postById = postDAO.getPostById(postId);
        if (postById.isEmpty()) {
            return "redirect:/posts";
        }
        model.addAttribute("sessionObject", this.sessionObject);
        model.addAttribute("post", postById.get());
        return "edit";
    }
    @RequestMapping(path = "/post/edit/{postId}", method = RequestMethod.POST)
    public String editPost(@ModelAttribute Post post,
                           @PathVariable int postId) {
        try {
            postDAO.editPost(post,postId);
        } catch (Exception e) {
           e.printStackTrace();
            System.out.println("weszło do catch");
            return "redirect:/edit/post/"+postId;
        }
        return "redirect:/posts";
    }
}
