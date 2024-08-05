package com.retailer.reward.dto;

import java.util.List;

public class RewardsResponseDTO {

//	private Integer id;
	private String name;
	private Integer year;
	private List<MonthWisePointsDTO> monthWisePoints;
	private double totalPoints;

	public RewardsResponseDTO() {

	}

	public RewardsResponseDTO(Integer id, String name, Integer year, List<MonthWisePointsDTO> monthWisePoints,
			double totalPoints) {
		super();
//		this.id = id;
		this.name = name;
		this.year = year;
		this.monthWisePoints = monthWisePoints;
		this.totalPoints = totalPoints;
	}

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<MonthWisePointsDTO> getMonthWisePoints() {
		return monthWisePoints;
	}

	public void setMonthWisePoints(List<MonthWisePointsDTO> monthWisePoints) {
		this.monthWisePoints = monthWisePoints;
	}

	public double getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}

}
