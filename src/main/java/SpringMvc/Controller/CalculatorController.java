package SpringMvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model) {

        double result;

        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double) b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("result", result);
        return "HtmlView/CalculatorView";
    }

    @GetMapping("/exit")
    public String exit() {
        return "HtmlView/Exit";
    }
}
