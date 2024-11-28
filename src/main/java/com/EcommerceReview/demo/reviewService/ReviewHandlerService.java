package com.EcommerceReview.demo.reviewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceReview.demo.Repository.ReviewRepository;
import com.EcommerceReview.demo.model.Product;
import com.EcommerceReview.demo.model.Review;
import com.EcommerceReview.demo.model.User;

@Service
public class ReviewHandlerService {

	@Autowired
	ReviewRepository reviewRepository;

	public void saveUserReview(User user, Review review, Long productId) {
		try {
			Review newReview = new Review();
			Product product = new Product();
			Boolean isVerified = false;
			List<Long> productIds = user.getProductsPurchased();
			for (int i = 0; i < productIds.size(); i++) {
				if (productId == productIds.get(i)) {
					isVerified = true;
				}
			}
			newReview.setRating(review.getRating());
			newReview.setReviewBody(review.getReviewBody());
			newReview.setProductId(productId);
			newReview.setUserId(user.getUserId());
			if (isVerified)
				newReview.setIsCertified(true);
			else
				newReview.setIsCertified(false);
			reviewRepository.save(newReview);
		} catch (Exception e) {

		}
	}
	
	public List<Review> getReviewByUser(User user) {
		List<Review> reviewByUsers = new ArrayList<>();
		return reviewByUsers = reviewRepository.findByUserId(user.getUserId());
	}
	
	public List<Review> getReviewByProductId(Long productId) {
		List<Review> reviewByProductId = new ArrayList<>();
		return reviewByProductId = reviewRepository.findByProductId(productId);
	}

	public Double getReviewSummary(Long reviewId) {
		Double reviewSummaryResult = reviewRepository.findReviewSummaryById(reviewId);
		return reviewSummaryResult;
	}

	public List<Review> getTopRatedReviews(Long reviewId) {
		// can write a query;
		List<Review> reviewsTop = reviewRepository.findTopReviews(reviewId);
		return reviewsTop;
	}

	public List<Review> getCertifiedReviews(Long productId) {
		List<Review> certifiedReviews = new ArrayList<>();
		reviewRepository.findByCertified(productId);
		return null;
	}
	
}













