package com.example.thymeleaf_demo.controller;

import javax.validation.Valid;

import com.example.thymeleaf_demo.dto.DtoCar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class MainController {

    private static Collection<DtoCar> carList = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("carList", carList);
        return "index";
    }

    @GetMapping("/car")
    public String createCar(Model model) {
        model.addAttribute("car", new DtoCar());
        return "carForm";
    }

    @PostMapping("/car")
    public String createCar(@Valid @ModelAttribute("car") DtoCar car, BindingResult bindingResult) {

        //System.out.println("bindingResult has Errors: " + bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            return "carForm";
        }
        else {
            carList.add(car);
        }

        return "redirect:/";
    }
}
