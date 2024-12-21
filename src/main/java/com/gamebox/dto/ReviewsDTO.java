package com.gamebox.dto;

import java.sql.Timestamp;

public class ReviewsDTO {


    private int reviewId;          // REVIEW_ID
    private int userId;            // USER_ID (FK)
    private int gameId;            // GAME_ID (FK)
    private double rating;         // RATING (2,1)
    private String reviewComment;  // REVIEW_COMMENT (CLOB in DB)
    private Timestamp createdAt;   // CREATED_AT
    
    
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
    
	
}
