package com.codeup.springblog.Controllers.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number, @PathVariable int number2) {
        return String.format("%d plus %d is equal to %d.", number, number2, (int) (Math.addExact(number, number2)));
    }
    @RequestMapping(path = "/subtract/{number}/from/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int number, @PathVariable int number2) {
        return String.format("%d minus %d is equal to %d.", number, number2, (int) (Math.subtractExact(number2, number)));
    }
    @RequestMapping(path = "/multiply/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int number, @PathVariable int number2) {
        return String.format("%d times %d is equal to %d.", number, number2, (number * number2));
    }
    @RequestMapping(path = "/divide/{number}/by/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int number, @PathVariable int number2) {
        return String.format("%d divided by %d is equal to %d.", number, number2, (number / number2));
    }
}
