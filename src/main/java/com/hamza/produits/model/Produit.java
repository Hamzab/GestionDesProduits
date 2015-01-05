package com.hamza.produits.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUIT")
public class Produit {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
  int id;
  String name;
  int price;
  int quantity;
  
public Produit() {
	super();
	// TODO Auto-generated constructor stub
}

public Produit(int id, String name, int price, int quantity) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}



public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Produit [id=" + id + ", name=" + name + ", price=" + price
			+ ", quantity=" + quantity + ", getId()=" + getId()
			+ ", getName()=" + getName() + ", getPrice()=" + getPrice()
			+ ", getQuantity()=" + getQuantity() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			+ "]";
}  
}
