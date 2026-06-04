package com.acl.ecom.service;


import com.acl.ecom.domain.Produit;
import org.springframework.stereotype.Service;



public interface ProduitService {

    Produit create(Produit p);
    Produit findById(long id);
    void delete(Long id);
    Produit update(Long id, Produit p);

}
