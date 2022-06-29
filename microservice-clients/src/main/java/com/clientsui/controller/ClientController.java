package com.clientsui.controller;

import beans.ProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clientsui.proxies.MicroserviceProduitsProxy;

import java.util.List;

@Controller
public class ClientController {

    private  MicroserviceProduitsProxy produitsProxy;

    public ClientController(MicroserviceProduitsProxy produitsProxy) {
        this.produitsProxy = produitsProxy;
    }

    @RequestMapping("/")

    public String accueil(Model model) {
        List<ProductBean> products =produitsProxy.listeDesProduits();
        model.addAttribute("produits", products);

        return "Accueil";

    }
    @RequestMapping("/details-produit/{id}")
    public String getDetail(@PathVariable int id, Model model)
    {
        ProductBean product =produitsProxy.recupererUnProduit(id);
        model.addAttribute("produit",product);
        return "FicheProduit";
    }


}