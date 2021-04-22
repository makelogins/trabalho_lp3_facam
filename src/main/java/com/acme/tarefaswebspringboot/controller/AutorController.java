package com.acme.tarefaswebspringboot.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.acme.tarefaswebspringboot.model.Moeda;


@Controller
@RequestMapping("/")
public class AutorController {

    RestTemplate rest = new RestTemplate();

    @GetMapping
    String index() {
      
        return "cota/index";
    }

    @GetMapping("/Rd")
    String novo(Model model) {
    	List<Moeda> realDolar = rest.getForObject("https://economia.awesomeapi.com.br/BRL-USD/1" , List.class);
       	model.addAttribute("moeda", realDolar);
        return "cota/form";
    }
    
        
    @GetMapping("/Dr")
    String novo1(Model model) {
    	List<Moeda> dolarReal = rest.getForObject("https://economia.awesomeapi.com.br/USD-BRL/1" , List.class);
       	System.out.print(dolarReal);
       	 model.addAttribute("moeda", dolarReal);
        return "cota/form";
    }

 
    



}
