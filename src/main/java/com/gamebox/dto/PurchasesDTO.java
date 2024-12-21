package com.gamebox.dto;

import java.sql.Timestamp;

public class PurchasesDTO {
	
	private int purchaseId;			// PURCHASE_ID
	private int userId;				// USER_ID (FK)
	private int gameId;				// GAME_ID (FK)
	private Timestamp purchasedAt;	// PURCHASED_AT
	
	
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
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
	public Timestamp getPurchasedAt() {
		return purchasedAt;
	}
	public void setPurchasedAt(Timestamp purchasedAt) {
		this.purchasedAt = purchasedAt;
	}
	
	
}
