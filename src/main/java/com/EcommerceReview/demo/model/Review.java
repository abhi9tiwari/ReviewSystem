package com.EcommerceReview.demo.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Review {
	@Id
	Long reviewId;
	String reviewBody;
	Long rating;
	Boolean isCertified;
	Long ProductId;
	Long userId;
	Long reviewSummary;
	Double reviewCount;
}
