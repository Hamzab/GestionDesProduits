package com.hamza.produits.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hamza.produits.model.Produit;





@Repository
public class ProduitDAO {
	 private static final Logger logger = LoggerFactory.getLogger(ProduitDAO.class);
	 
	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	 public void addProduit(Produit p){
		  Session session = this.sessionFactory.getCurrentSession();
	        session.persist(p);
	        logger.info("Produit saved successfully, Produit Details="+p);	 
	 }
	 
	 public void editProduit(Produit p){
		
	     Session session = this.sessionFactory.getCurrentSession();
	    
	        session.update(p);
	        logger.info("Produit updated successfully, Produit Details="+p); 
	 }
	 
	 public void removeProduit(int id){
		    Session session = this.sessionFactory.getCurrentSession();
	        Produit p = (Produit) session.load(Produit.class, new Integer(id));
	        if(null != p){
	            session.delete(p);
	        }
	        logger.info("Produit deleted successfully, Produit details="+p);
	 }
	 
	 @SuppressWarnings("unchecked")
	 public List<Produit> getProduits(){
		 Session session = this.sessionFactory.getCurrentSession();
	        List<Produit> produitsList =session.createQuery("from Produit").list();
	        for(Produit p : produitsList){
	            logger.info("Produit List::"+p);
	        }
	        return produitsList; 
	 }
	 
	 public Produit getProduitByID(int id){
		   Session session = this.sessionFactory.getCurrentSession();      
		   Produit p = (Produit) session.load(Produit.class, new Integer(id));
	        logger.info("Produit loaded successfully, Produit details="+p);
	        return p;
	 }
}
