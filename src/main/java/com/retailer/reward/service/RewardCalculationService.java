package com.retailer.reward.service;

import java.util.List;
import java.util.Map;

import com.retailer.reward.dto.RewardsResponseDTO;

public interface RewardCalculationService {
	public List<RewardsResponseDTO> calculateRewards();
}
