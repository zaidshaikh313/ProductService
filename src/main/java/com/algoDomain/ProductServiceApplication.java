package com.algoDomain;

import com.algoDomain.entity.Category;
import com.algoDomain.entity.Product;
import com.algoDomain.repositories.CategoryRepo;
import com.algoDomain.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 =new Category("Electronics",15,18,350);
		Category cat2 =new Category("Home Appliances",22,24,800);
		Category cat3 =new Category("Clothing",40,12,0);
		Category cat4 =new Category("Furniture",10,18,300);
		categoryRepo.save(cat1);
		categoryRepo.save(cat2);
		categoryRepo.save(cat3);
		categoryRepo.save(cat4);
		Product product =new Product("Lenovo Yoga","Laptop",45000f,false,cat1);
		Product product1 =new Product("LG Washing Machine ","Washing Machine",25000f,false,cat2);
		Product product2 =new Product("HP Pavilion 360","Laptop",60000f,false,cat1);
		Product product3 =new Product("US Polo Assn","T-Shirt",1200f,false,cat3);
		Product product4 =new Product("Neelkamal Been Bag","Sofa Set",350f,false,cat4);
		productRepo.save(product);
		productRepo.save(product1);
		productRepo.save(product2);
		productRepo.save(product3);
		productRepo.save(product4);

	}
}
