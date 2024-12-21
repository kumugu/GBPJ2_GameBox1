package com.gamebox.dto;

import java.sql.Timestamp;

public class LibraryDTO {

	private int libraryId;			// LIBRARY_ID
	private int userId;				// USER_ID (FK)
	private int gameId;				// GAME_ID (FK)
	private Timestamp lastPlayed;	//LAST_PLAYED
	
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
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
	public Timestamp getLastPlayed() {
		return lastPlayed;
	}
	public void setLastPlayed(Timestamp lastPlayed) {
		this.lastPlayed = lastPlayed;
	}
	
	
	
}
