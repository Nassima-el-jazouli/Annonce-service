package org.lsi.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lsi.entities.Product;
import org.lsi.exception.ResourceNotFoundException;
import org.lsi.feign.userFeign;
import org.lsi.repositories.ProductRepository;
import org.lsi.web.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/annonces")
public class ProductController {
    
	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
    private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private userFeign userfeign;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
    
    @GetMapping("/products/{id}")
    public ResponseEntity < Product > getProductById(@PathVariable(value = "id") String productId)
    throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
    	//product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
        return productRepository.save(product);
    }
    
    
    @PutMapping("/products/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable(value = "id") String productId,
        @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setAddress(productDetails.getAddress());
        product.setImage(productDetails.getImage());
        product.setDescription(productDetails.getDescription());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
        
    }

    @DeleteMapping("/products/{id}")
    public Map < String, Boolean > deleteProduct(@PathVariable(value = "id") String productId)
    throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    
    @GetMapping("/consulterById")
	public List<Product> showProductsListByUserId(HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		return productRepository.findAllById(id); //must be changed to metier
	}
}
