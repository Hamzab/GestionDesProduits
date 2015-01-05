package com.hamza.produits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hamza.produits.model.Produit;
import com.hamza.produits.service.ProduitService;


@Controller
public class ProduitController {

private ProduitService produitService;
@Autowired(required=true)
@Qualifier(value="produitService")
public  void setProduitService(ProduitService ps){
	produitService=ps;
}

@RequestMapping(value = "/", method = RequestMethod.GET)
public String getIndex(){
	return "home";
}

@RequestMapping(value = "/produits", method = RequestMethod.GET)
public String getProduits(Model model){
	
	model.addAttribute("produit",new Produit());
	
	model.addAttribute("lesProduits", produitService.getProduits());
	
	return "produit";
}
@RequestMapping(value = "/produit/add", method = RequestMethod.POST)
public String addProduit(@ModelAttribute("produit") Produit p){
	 
    if(p.getId()==0){
    	produitService.addProduit(p);
    }else{
    	
    	produitService.updateProduit(p);
    	
    }
    return "redirect:/produits";
}
@RequestMapping(value = "/remove/{id}")
public String removeProduit(@PathVariable("id") int id){
	produitService.removeProduit(id);
	return "redirect:/produits";
}

@RequestMapping(value = "/edit/{id}")
public String editProduit(@PathVariable("id") int id, Model model){
	
	model.addAttribute("produit",produitService.getProduitByID(id));
	model.addAttribute("lesProduits",produitService.getProduits());
	
	return "produit";
}

}
