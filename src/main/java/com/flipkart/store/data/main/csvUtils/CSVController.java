package com.flipkart.store.data.main.csvUtils;

import java.util.List;

import javax.print.PrintException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.flipkart.store.data.main.model.ProductOfCapCorner;

/*
 * In controller package, we create CSVController class for Rest Apis.
– @CrossOrigin is for configuring allowed origins.
– @Controller annotation indicates that this is a controller.
– @GetMapping and @PostMapping annotation is for mapping HTTP GET & POST requests onto specific handler methods:

POST /upload: uploadFile()
GET /tutorials: getAllTutorials()
– We use @Autowired to inject implementation of CSVService bean to local variable.
 */

//@CrossOrigin("http://localhost:8081")
@CrossOrigin()
@Controller
@RequestMapping("user")
public class CSVController {
	@Autowired
	CSVService fileService;

	@PostMapping("admin/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		if (CSVHelper.hasCSVFormat(file)) {
			try {
				fileService.save(file);
				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	@GetMapping("admin/tutorials")
	public ResponseEntity<List<ProductOfCapCorner>> getAllTutorials() {
		try {
			List<ProductOfCapCorner> tutorials = fileService.getAllTutorials();
			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}