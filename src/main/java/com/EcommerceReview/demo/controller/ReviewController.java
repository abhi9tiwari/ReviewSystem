package com.EcommerceReview.demo.controller;

import java.util.List;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EcommerceReview.demo.model.Review;
import com.EcommerceReview.demo.model.User;
import com.EcommerceReview.demo.reviewService.ReviewHandlerService;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewHandlerService reviewHandlerService;
	
	@PostMapping("/review/addProductReview")
	public void addReviewOfProduct(User user, Review review, Long productId) {
		try {
			if(user == null) {
				throw new BadRequestException("User is mandatory");
			}
			if(review == null) {
				throw new BadRequestException("rating is mandatory");
			}
			if(productId == null) {
				throw new BadRequestException("productId is mandatory");
			}
			if(review.getRating() < 5 || review.getRating() > 0) {
				throw new BadRequestException("Review value should be between 0 to 5");
			}
			reviewHandlerService.saveUserReview(user, review, productId);
		}catch(Exception e) {
			
		}
	}
	
	@GetMapping("/review/getReviewByUser")
	public List<Review> getUserReviews(User user) throws BadRequestException {
		if(user == null) {
			throw new BadRequestException("user is mandatory");
		}
		return reviewHandlerService.getReviewByUser(user);
	}
	
	@GetMapping("/reviews/productId")
	public List<Review> getReviewByProductId(Long productId) throws BadRequestException{
		if(productId == null) {
			throw new BadRequestException("product id is mandatory");
		}
		return reviewHandlerService.getReviewByProductId(productId);
	}
	
	@GetMapping("/reviews/summary/reviews")
	public Double getSummaryRatings(Long productId) {
		return reviewHandlerService.getReviewSummary(productId);
	}
	
	@GetMapping("/reviews/sort/reviews")
	public List<Review> getReviewList(Long reviewId) throws BadRequestException{
		if(reviewId == null) {
			throw new BadRequestException ("reviewId is mandatory");
		}
		return reviewHandlerService.getTopRatedReviews(reviewId);
	}
	
	public List<Review> getCertifiedReviews(Long productId) throws BadRequestException{
		if(productId == null) {
			throw new BadRequestException ("reviewId is mandatory");
		}
		return reviewHandlerService.getCertifiedReviews(productId);
	}
	
}























