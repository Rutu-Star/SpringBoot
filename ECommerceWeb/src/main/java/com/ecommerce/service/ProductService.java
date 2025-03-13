package com.ecommerce.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.Product;
import com.ecommerce.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired 
	ProductRepo productRepo;

	public List<Product> getALlProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
		
	}

	public Product getById(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElse(null);
		
	}

	//add product 
	public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
		
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageDate(imageFile.getBytes());
		
		
		return productRepo.save(product);
	}

	//Update Product 
	public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
		// TODO Auto-generated method stub
		/*Optional<Product> existingOpt=productRepo.findById(id);
		
		if(existingOpt.isPresent())
		{
			Product existingProduct=existingOpt.get();
			existingProduct.setName(product.getName());
			existingProduct.setBrand(product.getBrand());
			existingProduct.setCategory(product.getBrand());
			existingProduct.setDescription(product.getDescription());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setQuantity(product.getQuantity());
			existingProduct.setReleaseDate(product.getReleaseDate());
			
			if(imageFile!=null)
			{
				existingProduct.setImageName(product.getImageName());
				existingProduct.setImageType(product.getImageType());
				existingProduct.setImageDate(product.getImageDate());
			}
			
			return productRepo.save(existingProduct);
			
		}
		else
		{
			return null;
		}
		*/
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageDate(imageFile.getBytes());
		return productRepo.save(product);
	}

	//Delete Product 
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
		
		productRepo.deleteById(id);
		
	}

	//Search the products 
	public List<Product> searchProductS(String keyword) {
		// TODO Auto-generated method stub
		return productRepo.searchProducts(keyword);
	}

}
