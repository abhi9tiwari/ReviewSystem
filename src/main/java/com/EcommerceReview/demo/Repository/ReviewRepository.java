package com.EcommerceReview.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.EcommerceReview.demo.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>  {
	
	public List<Review> findByUserId(Long userId);
	public List<Review> findByProductId(Long productId);
	public Double findReviewSummaryById(Long reviewId);
	public List<Review> findByCertified(Long productId);
	
	@Query(findTopReviews)
	public List<Review> findTopReviews(Long reviewId);
	
	String findTopReviews = "Select * from Reviews where reviewId = ?reviewId order by rating desc";

	
}
