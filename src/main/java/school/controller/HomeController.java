package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import school.service.HomeService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("/")
    public String showHome(Model model) {
        String message = homeService.getWelcomeMessage();
        model.addAttribute("myMessage", message);
        return "home";
    }

}
