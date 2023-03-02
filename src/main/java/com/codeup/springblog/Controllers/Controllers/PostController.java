package com.codeup.springblog.Controllers.Controllers;

import com.codeup.springblog.Controllers.Model.Post;
import com.codeup.springblog.Controllers.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repositories.PostRepository;
import repositories.UserRespository;
import services.EmailService;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    private final UserRespository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRespository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String postsHome(Model model) {
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsHome(PathVariable Long id, Model model) {
        Post post = postDao.findPostById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("heading", "Create new post");
        return "posts/create";
    }

    @PostMapping("/posts/save")
    public String createPost(@ModelAttribute Post post) {
        User user = userDao.findUserById(1);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(Model model, @PathVariable long id) {
        model.addAttribute("post", postDao.findPostById(id));
        model.addAttribute("heading", "Edit Post");
        return "posts/create";
    }
}
