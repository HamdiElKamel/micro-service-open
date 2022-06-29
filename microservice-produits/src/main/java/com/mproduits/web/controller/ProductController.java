package com.mproduits.web.controller;

import com.mproduits.dao.ProductDao;
import com.mproduits.exception.ProducrNotFoundException;
import com.mproduits.model.Product;
import com.mproduits.web.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@CrossOrigin("*")
@RequestMapping("produit/")
public class ProductController {

    @Autowired
    ProductDao productDao;

    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "all")
    public List<Product> listeDesProduits(){
        System.out.println("hello produit");
        List<Product> products = productDao.findAll();

        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

        return products;

    }

    //Récuperer un produit par son id
    @GetMapping( value = "by-id/{id}")
    public Optional<Product> recupererUnProduit(@PathVariable int id) {

        Optional<Product> product = productDao.findById(id);

        if(!product.isPresent())  throw new ProducrNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

        return product;
    }
}

