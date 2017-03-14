package com.polteq;

import java.lang.String;


public class Product { 
		private String productName;
		private String measureUnit;
		private String measureAmount;


		public Product(String productName, String measureUnit, String measureAmount) {
			super();
			this.productName = productName;
			this.measureUnit = measureUnit;
			this.measureAmount = measureAmount;
		}

		public String getproductName() {
			return productName;
		}
		
		public String getmeasureUnit() {
			return measureUnit;
		}
		
		public String getmeasureAmount() {
			return measureAmount;
		}

		public void setproductName(String productName) {
			this.productName = productName;
		}

		public void setmeasureUnit(String measureUnit) {
			this.measureUnit = measureUnit;
		}
		
		public void setmeasureAmount(String measureAmount) {
			this.measureAmount = measureAmount;
		}
		
		@Override
		public String toString() {
			return "Product [name=" + productName + ", size=" + measureAmount +" " 
					+ measureUnit+"]";
		}
	}
