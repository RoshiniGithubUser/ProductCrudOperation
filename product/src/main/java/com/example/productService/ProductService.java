package com.example.productService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productEntity.Product;
import com.example.productRepository.ProductRepository;

@Service
public class ProductService {

	    @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Product getProductById(Long id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Product updateProduct(Long id, Product product) {
	        if (productRepository.existsById(id)) {
	            product.setId(id);
	            return productRepository.save(product);
	        }
	        return null;
	    }

	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
	}


