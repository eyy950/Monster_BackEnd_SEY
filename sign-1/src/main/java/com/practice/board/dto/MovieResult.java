package com.practice.board.dto;

public class MovieResult {

    private String title;
    private String release_date;
    private double vote_average;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public double getVote_average() {
		return vote_average;
	}
	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}

    // Getter, Setter, 기타 필요한 메서드들을 추가하세요.

}
