package com.retailer.reward.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.reward.service.RewardCalculationService;

@RestController
@RequestMapping("/api/reward/")
public class RewardCalculationController {

	@Autowired
	private RewardCalculationService rewardservice;

	@GetMapping
	public Map<String, Map<String, Integer>> getRewards() {
		return rewardservice.calculateRewards();
	}
	@GetMapping(path = "get")
	public String getRewards1() {
		return "Test2";
	}

}
