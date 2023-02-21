package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PathController {
    @GetMapping(path = "/posts")
    @ResponseBody
    public String posts() {
        return "posts index page ";
    }
    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String postsId(@PathVariable long id){
        return "view an individual post" + id;
    }
    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String create(){
        return "view the form for creating a post";
    }
    @PostMapping("/posts/create")
    public void createPosts(){
    }
}
