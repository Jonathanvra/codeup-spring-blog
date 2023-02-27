package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(Model model){
        model.addAttribute("name", "World");
        return "Hello, !";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(Model model) {
        model.addAttribute("name", "World");
        return "hello";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable long number){
        return String.format("%d plus 1 is %d", number, number + 1);
    }

    @GetMapping("/exponent/{num}/{pow}")
    public String exponent(@PathVariable int num, @PathVariable int pow, Model model){
        model.addAttribute("num", num);
        model.addAttribute("pow", pow);
        model.addAttribute("result", (int) Math.pow(num, pow));
        return "exponent";
    }
}
