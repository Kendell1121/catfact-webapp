package com.example.catfacts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class CatFactController {

    private static final String API_URL = "https://catfact.ninja/fact";

    @GetMapping("/")
    public String getCatFact(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        CatFact response = restTemplate.getForObject(API_URL, CatFact.class);
        String fact = (response != null) ? response.getFact() : "Could not fetch a cat fact.";
        model.addAttribute("fact", fact);
        return "index";
    }
}
