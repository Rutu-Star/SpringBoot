package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "http://localhost:5173/") // Allow only React frontend
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//fetch all products
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getALlProduct()
	{
		return new ResponseEntity<>(productService.getALlProduct(),HttpStatus.OK) ;
		 
	}
	
	//fetch product by id
	@GetMapping("/product/{id}")
	public ResponseEntity<Product>  getById(@PathVariable int id)
	{
		
		Product product=productService.getById(id);
		if(product!=null)
		{
		return new ResponseEntity<>(productService.getById(id),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Add product 
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile)
	{
		try
		{
			System.out.println(product);
			Product product1=productService.addProduct(product,imageFile);
			return new ResponseEntity<>(product1,HttpStatus.CREATED);
			
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//get image 
	@GetMapping("/product/{productId}/image")
	public ResponseEntity<byte[]> getImageByProductID(@PathVariable int productId)
	{
		Product product=productService.getById(productId);
		byte[] imageFile=product.getImageDate();
		return ResponseEntity.ok()
				.contentType(MediaType.valueOf(product.getImageType()))
				.body(imageFile);
	}
	
	//update product
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product, @RequestPart MultipartFile imageFile)
	{
		Product product1=null;
		try {
			product1 = productService.updateProduct(id,product,imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>("Failed to update ",HttpStatus.BAD_REQUEST);
		}
		if(product1!=null)
		{
			return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//Delete product 
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		Product product=productService.getById(id);
		if(product!=null)
		{
			productService.deleteProduct(id);
			return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Product not found ",HttpStatus.NOT_FOUND);
		}
	}
	
	//search the products 
	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam   String keyword)
	{
		//System.out.println("Keyword "+keyword);
		
		List<Product> products=productService.searchProductS(keyword);
		return  new ResponseEntity<>(products,HttpStatus.OK);
	}

}
