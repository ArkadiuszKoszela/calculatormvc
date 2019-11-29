package pl.koszela.calculator.calculatormvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.koszela.calculator.calculatormvc.ServiceAccessories;

import java.util.Objects;

@Controller
@RequestMapping("")
public class ControllerAccessories {

    private ServiceAccessories serviceAccessories;

    @Autowired
    public ControllerAccessories(ServiceAccessories serviceAccessories) {
        this.serviceAccessories = Objects.requireNonNull(serviceAccessories);
    }

    @GetMapping("/list")
    public String showAccessories(Model model) {

        model.addAttribute("basic", serviceAccessories.find("podstawowy"));
        model.addAttribute("premium", serviceAccessories.find("premium"));
        model.addAttribute("lux", serviceAccessories.find("lux"));

        return "accesories/basicAccessories";
    }
}