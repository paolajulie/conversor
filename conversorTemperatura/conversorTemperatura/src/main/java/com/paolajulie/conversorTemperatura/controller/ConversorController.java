package com.paolajulie.conversorTemperatura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConversorController {
    @GetMapping("/")
    private ModelAndView conversor(){
        ModelAndView model = new ModelAndView();
        model.setViewName("temperatura");
        return model;
    }

    @PostMapping("/converter")
    private String converter(@RequestParam("numero") Float numero,
                             @RequestParam("temperatura") String temperatura,
                             Model model){
        String resultado = "";

        // kelvinToCelsius
        // kelvinToFar
        // celsiusToKelvin
        // celsiusToFar
        // farToKelvin
        // farToCelsius

        switch(temperatura){
            case "kelvinToCelsius":
                resultado = (numero - 273) +"°c";
                break;
            case "kelvinToFar":
                resultado = ((numero - 273)* 1.8 + 32)+ "°f" ;
                break;
            case "celsiusToKelvin":
                resultado = (numero + 273)+"k";
                break;
            case "celsiusToFar":
                resultado = (numero * 1.8)+ 32 + "°f";
                break;
            case "farToKelvin":
                resultado = (numero + 32) * (5/9) + 273 +"k";
                break;
            case "farToCelsius":
                resultado = (numero - 32) / 1.8 +"°c";
                break;


        }

        model.addAttribute("result",resultado);
        return "temperatura";
    }

}
