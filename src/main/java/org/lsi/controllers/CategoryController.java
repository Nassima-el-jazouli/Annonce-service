package org.lsi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.lsi.entities.Category;
import org.lsi.exception.ResourceNotFoundException;
import org.lsi.repositories.CategoryRepository;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/annonces")
public class CategoryController {
    
	@Autowired
    private CategoryRepository categoryRepository;
	
	@Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }
    
    @GetMapping("/categories/{id}")
    public ResponseEntity < Category > getCategoryById(@PathVariable(value = "id") String categoryId)
    throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));
        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody String name) {
    	//category.setId(sequenceGeneratorService.generateSequence(Category.SEQUENCE_NAME));
    	Category c=new Category(name);
        return categoryRepository.save(c);
    }
    
    
    @PutMapping("/categories/{id}")
    public  Category  updateCategory(@PathVariable(value = "id") String categoryId,
        @Valid @RequestBody String name) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

        category.setName(name);
       return categoryRepository.save(category);
         
        
    }

    @DeleteMapping("/categories/delete/{id}")
    public Map < String, Boolean > deleteCategory(@PathVariable(value = "id") String categoryId)
    throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

        categoryRepository.delete(category);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

