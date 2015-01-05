package com.hamza.produits.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamza.produits.dao.ProduitDAO;
import com.hamza.produits.model.Produit;




@Service
public class ProduitService {
  private ProduitDAO produitdao;
  
  public void setProduitDAO(ProduitDAO produitdao) {
      this.produitdao = produitdao;
  }
  
  @Transactional
  public void addProduit(Produit p){
	  produitdao.addProduit(p);
  }
  
  @Transactional
  public void updateProduit(Produit p){
	  produitdao.editProduit(p);;
  }
  @Transactional
  public List<Produit> getProduits(){
	  return produitdao.getProduits();
  }
  @Transactional
  public Produit getProduitByID(int id){
	  return produitdao.getProduitByID(id);
  }
  
  @Transactional
  public void removeProduit(int id){
	  produitdao.removeProduit(id);
  }
}
