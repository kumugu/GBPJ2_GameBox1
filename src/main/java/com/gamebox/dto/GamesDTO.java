package com.gamebox.dto;

import java.sql.Timestamp;

public class GamesDTO {
	
    private int gameId;          // GAME_ID
    private String title;        // TITLE
    private String description;  // DESCRIPTION
    private double price;        // PRICE
    private String gameImage;    // GAME_IMAGE
    private Timestamp createdAt; // CREATED_AT
    
    
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
    
}
