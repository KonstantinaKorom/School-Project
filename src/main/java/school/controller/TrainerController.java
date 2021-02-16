package school.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import school.entity.Trainer;
import school.service.TrainerServiceInterface;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerServiceInterface trainerService;

    @RequestMapping
    public ModelAndView showTrainers(ModelAndView modelAndView) {
        List<Trainer> trainers = trainerService.findAll();
        modelAndView.addObject("listOfTrainers", trainers);
        modelAndView.setViewName("trainer/trainersList");

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("trainer") Trainer trainer) {
        return "trainer/trainerForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("trainer") Trainer trainer,
            BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "trainer/trainerForm";
        }
        trainerService.save(trainer);
        String message = "Trainer " + trainer.getTfirstname()+ " " + trainer.getTlastname() + " successfully created!";
        attributes.addFlashAttribute("message", message);
        return "redirect:/trainer";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable("id") int id, Model model) {
        Trainer trainer = trainerService.findById(id);
        model.addAttribute("trainer", trainer);
        return "trainer/trainerForm";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("trainer") Trainer trainer,
            BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "trainer/trainerForm";
        }
        trainerService.save(trainer);
        String msg = "Trainer " + trainer.getTfirstname() + trainer.getTlastname() + " updated successfully!";
        attributes.addFlashAttribute("message", msg);
        return "redirect:/trainer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes) {
        trainerService.delete(id);
        String msg = "Trainer successfully deleted!";
        attributes.addAttribute("message", msg);
        return "redirect:/trainer";
    }

    @ModelAttribute(name = "listOfSubjects")
    public List<String> getSubjects() {
        return trainerService.getSubjects();
    }
}
