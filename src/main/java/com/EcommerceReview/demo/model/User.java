package com.EcommerceReview.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {
	@Id
	Long userId;
	List<Long> productsPurchased;
}
