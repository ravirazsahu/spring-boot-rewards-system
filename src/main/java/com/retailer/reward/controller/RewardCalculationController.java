package com.retailer.reward.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.reward.dto.RewardsResponseDTO;
import com.retailer.reward.handlers.ResponseHandler;
import com.retailer.reward.service.RewardCalculationService;

@RestController
@RequestMapping("/api/reward")
public class RewardCalculationController {
//	private static final Logger logger = LoggerFactory.getLogger(RewardCalculationController.class);

	@Autowired
	private RewardCalculationService rewardservice;

	@GetMapping
	public ResponseEntity<Object> getRewards() {

		List<RewardsResponseDTO> calculatedRewards = rewardservice.calculateRewards();
		if (calculatedRewards.isEmpty()) {
			return ResponseHandler.createResponse("Data is not available !", HttpStatus.OK, null);
		}
		return ResponseHandler.createResponse("Data Retrieved Successfully.", HttpStatus.OK, calculatedRewards);

	}

}
