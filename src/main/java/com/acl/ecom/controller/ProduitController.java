package com.acl.ecom.controller;

import com.acl.ecom.domain.Produit;
import com.acl.ecom.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor

public class ProduitController {
    private final ProduitService produitService;

    @PostMapping
    public Produit save(@RequestBody Produit p){
        return produitService.create(p);
    }

    @GetMapping("/{id}")
    public Produit findById(@PathVariable Long id) {
        return produitService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produitService.delete(id);

    }

    @PutMapping("/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit p) {
        return produitService.update(id, p);
    }



}
