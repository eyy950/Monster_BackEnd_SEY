package com.practice.board.dto;

public class TVSeriesResult {

    private String name;
    private String first_air_date;
    private double vote_average;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirst_air_date() {
		return first_air_date;
	}
	public void setFirst_air_date(String first_air_date) {
		this.first_air_date = first_air_date;
	}
	public double getVote_average() {
		return vote_average;
	}
	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}

    // Getter, Setter, 기타 필요한 메서드들을 추가하세요.
}
