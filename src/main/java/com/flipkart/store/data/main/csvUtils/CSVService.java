package com.flipkart.store.data.main.csvUtils;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;

import com.flipkart.store.data.main.model.ProductOfCapCorner;
import com.flipkart.store.data.main.repository.CategoryRepo;
import com.flipkart.store.data.main.repository.ProductRepo;

@Service
public class CSVService {
	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	ProductRepo repository;

	public void save(MultipartFile file) {
		try {
			List<ProductOfCapCorner> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
			
			repository.saveAll(tutorials);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	public List<ProductOfCapCorner> getAllTutorials() {
		return repository.findAll();
	}
}
/*
 * CSVService service class will be annotated with @Service annotation, it uses
 * CSVHelper and TutorialRepository for 2 functions:
 * 
 * save(MultipartFile file): store CSV data to database getAllTutorials(): read
 * data from database and return List<Tutorial>
 */