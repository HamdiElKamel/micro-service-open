package com.clientsui.proxies;

import beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(value = "microservice-produits",url = "http://localhost:9090/produit/")
public interface MicroserviceProduitsProxy {
    @GetMapping(value = "all")
    List<ProductBean> listeDesProduits();

    @GetMapping( value = "by-id/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);

}
