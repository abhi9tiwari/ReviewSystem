package com.EcommerceReview.demo.model;

import lombok.Data;

@Data
public class Product {
	Long productId;
	String productName;
	Review review;
	
}
