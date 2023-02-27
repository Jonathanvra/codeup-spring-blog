package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
        public String diceRoll() {
            return "roll-dice";
        }

    @GetMapping("/roll-dice/{x}")
    public String rollDice(@PathVariable String x, Model model) {
        model.addAttribute("x", x);
        int dice = (int) (Math.random() * 6 + 1);
        model.addAttribute("dice", dice);
        return "dice-results";
    }
}
