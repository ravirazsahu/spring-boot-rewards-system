package com.retailer.reward.dto;

public class MonthWisePointsDTO {

	private String month;
	private Integer points;

	public MonthWisePointsDTO(String month, Integer points) {
		this.month = month;
		this.points = points;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

}