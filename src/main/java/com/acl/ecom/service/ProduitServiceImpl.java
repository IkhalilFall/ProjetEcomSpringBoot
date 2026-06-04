package com.acl.ecom.service;

import com.acl.ecom.domain.Produit;
import com.acl.ecom.exception.ResourceNotFoundException;
import com.acl.ecom.repository.ProduitRepository;
import org.springframework.stereotype.Service;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository repository;

    public ProduitServiceImpl(ProduitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produit create(Produit p) {
        return repository.save(p);
    }

    @Override
    public Produit findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit " + id + " introuvable"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Produit update(Long id, Produit p) {
        Produit existant = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit " + id + " introuvable"));
        existant.setNom(p.getNom());
        existant.setPrix(p.getPrix());
        return repository.save(existant);
    }
}