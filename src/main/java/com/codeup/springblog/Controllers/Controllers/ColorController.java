package com.codeup.springblog.Controllers.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ColorController {
    @GetMapping("/fav-color")
    public String favColorFrom(){
        return "fav-color";
    }
    @PostMapping("/fav-color")
    @ResponseBody
    public String whatWasTheFavColor(@RequestParam(name = "color")String color){
        return String.format("User really likes the color, %s.", color);
    }
}
