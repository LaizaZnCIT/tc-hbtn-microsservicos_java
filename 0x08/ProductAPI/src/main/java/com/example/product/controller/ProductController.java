package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository repository;
	
	@PostMapping("/addProduct")
	@ApiOperation(value = "- Responsável por adicionar um produto.")
	@ApiResponses(value = {
			@ApiResponse(code = 10, message = "Required fields not informed.")
	})
	public void addProduct(@RequestBody Product product) {
		repository.addProduct(product);
	}
	
	@GetMapping("/allProducts")
	@ApiOperation(value = "- Responsável por retornar uma lista de produtos.")
	@ApiResponses(value = {
			@ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
	})				
	public List<Product> getAllProducts(){
		return repository.getAllProducts();
	}
	
	@GetMapping("/findProductById/{id}")
	@ApiOperation(value = "- Responsável por retornar um produto pelo id.")
	@ApiResponses(value = {
			@ApiResponse(code = 12, message = "The field id not informed. This information is required.")
	})
	public Product findProductById(@PathVariable("id") Long idProduct){
		return repository.getProductById(idProduct);
	}
	
	@DeleteMapping("/removeProduct")
	@ApiOperation(value = "- Responsável por remover um produto.")
	@ApiResponses(value = {
			@ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
	})
	public void deleteProductById(@RequestBody Product product) {
		repository.removeProduct(product);
	}
	
	@PutMapping("/updateProduct")
	@ApiOperation(value = "- Responsável por atualizar um produto.")
	@ApiResponses(value = {
			@ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
	})
	public void updateProduct(@RequestBody Product product) {
		repository.updateProduct(product);
	}
	
	@GetMapping("/welcome")
	@ApiOperation(value = "- Responsável por retornar uma mensagem de boas vindas.")
	public String mensagemBoasVindas() {
		return "Boas vindas!";
	}

}
