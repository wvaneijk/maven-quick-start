package com.polteq;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CSVhelper {

	private static final String COMMA_DELIMITER = ",";
	private static final int PRODUCT_NAME = 0;
	private static final int PRODUCT_MEASUREUNIT = 1;
	private static final int PRODUCT_MEASUREAMOUNT = 2;
	

	public void CSVreader() {
		
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("C:\\products.csv"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			List<Product> products = new ArrayList();
			String line = "";
			fileReader.readLine();

			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					Product product = new Product(tokens[PRODUCT_NAME], tokens[PRODUCT_MEASUREUNIT],
							tokens[PRODUCT_MEASUREAMOUNT]);
					products.add(product);
				}
			}

			for (Product product : products) {
				System.out.println(product.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}