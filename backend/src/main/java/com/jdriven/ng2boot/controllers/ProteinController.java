package com.jdriven.ng2boot.controllers;

import com.jdriven.ng2boot.entity.Protein;
import com.jdriven.ng2boot.service.ProteinService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/protein")
public class ProteinController {

    private final ProteinService proteinService;


    public ProteinController(ProteinService proteinService) {
        this.proteinService = proteinService;
    }

    @GetMapping("/{id}")
    public Protein getProtein(@PathVariable("id") Long id) {
        return proteinService.getProtein();
    }
}
