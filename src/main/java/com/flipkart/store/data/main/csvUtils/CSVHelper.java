package com.flipkart.store.data.main.csvUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.springframework.web.multipart.MultipartFile;


import com.flipkart.store.data.main.model.ProductOfCapCorner;


// We’re gonna use Apache Commons CSV classes such as: CSVFormat, CSVPrinter.

public class CSVHelper {

	public static String TYPE = "text/csv";
	static String[] HEADERs = { "category_id", "product_name", "product_description", "product_size", "brand_name",
			"product_code", "market_price", "discount", "capcorner_price" };

	// "product_id",
//	Integer.parseInt(csvRecord.get("product_id")),
	public static boolean hasCSVFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<ProductOfCapCorner> csvToTutorials(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<ProductOfCapCorner> tutorials = new ArrayList<ProductOfCapCorner>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				BigDecimal finalPrice = new BigDecimal(csvRecord.get("capcorner_price"));
				BigDecimal marketPrice = new BigDecimal(csvRecord.get("market_price"));
				BigDecimal discount = new BigDecimal(csvRecord.get("discount"));
 
				ProductOfCapCorner tutorial = new ProductOfCapCorner(Integer.parseInt(csvRecord.get("category_id")),

						csvRecord.get("product_name"),csvRecord.get("product_description"), csvRecord.get("product_size"), csvRecord.get("brand_name"),
						csvRecord.get("product_code"), discount, finalPrice, marketPrice

				);
				tutorials.add(tutorial);
			}
			return tutorials;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
}

/*
 * create BufferedReader from InputStream create CSVParser from the
 * BufferedReader and CSV format iterate over CSVRecords by Iterator with
 * CsvParser.getRecords() from each CSVRecord, use CSVRecord.get() to read and
 * parse fields Under helper package, we create CSVHelper class with 3 methods:
 * 
 * hasCSVFormat(): check if a file has CSV format or not csvToTutorials(): read
 * InputStream of a file, return a list of Tutorials
 */