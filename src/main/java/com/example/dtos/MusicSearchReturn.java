package com.example.dtos;

public class MusicSearchReturn {
	
	
	private Integer critiqueId;
	private String songName;	
	private String artist;
	private double songLength;
	private String genre;
	private String songCritique;
	
	
	
	public MusicSearchReturn() {
		super();
	}



	public MusicSearchReturn(Integer critiqueId, String songName, String artist, double songLength, String genre,
			String songCritique) {
		super();
		this.critiqueId = critiqueId;
		this.songName = songName;
		this.artist = artist;
		this.songLength = songLength;
		this.genre = genre;
		this.songCritique = songCritique;
	}



	public Integer getCritiqueId() {
		return critiqueId;
	}



	public void setCritiqueId(Integer critiqueId) {
		this.critiqueId = critiqueId;
	}



	public String getSongName() {
		return songName;
	}



	public void setSongName(String songName) {
		this.songName = songName;
	}



	public String getArtist() {
		return artist;
	}



	public void setArtist(String artist) {
		this.artist = artist;
	}



	public double getSongLength() {
		return songLength;
	}



	public void setSongLength(double songLength) {
		this.songLength = songLength;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getSongCritique() {
		return songCritique;
	}



	public void setSongCritique(String songCritique) {
		this.songCritique = songCritique;
	}
	
	
	
	
	
	

}
