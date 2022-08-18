package com.example.product.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
	private List<Product> list = new ArrayList<Product>();

	  public List<Product> getAllProducts() {
	    return list;
	  }

	  public Product getProductById(Long id) {
	    return list.stream().filter(p -> id.equals(p.getId())).findAny().orElse(null); 
	  }

	  public void addProduct(Product s) {
	    list.add(s);
	  }

	  public void updateProduct(Product s) {
	    int index = list.indexOf(s);
	    list.set(index, s);
	   }

	   public void removeProduct(Product s) {
	     list.remove(s);
	   }

	   public void addList(List<Product> listOfProducts) {
	     list.addAll(listOfProducts);
	   }

}
