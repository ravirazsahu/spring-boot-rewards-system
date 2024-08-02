package com.retailer.reward.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailer.reward.entity.RewardTransaction;
import com.retailer.reward.repo.RewardsRepository;

@Service
public class RewardCalculationServiceImpl implements RewardCalculationService {

	@Autowired
	private RewardsRepository rewardRepo;

	public Map<String, Map<String, Integer>> calculateRewards() {

		Map<String, Map<String, Integer>> rewards = new HashMap<>();

		List<RewardTransaction> rewardrepolist = rewardRepo.findAll();

		rewardrepolist.stream().forEach(transanction -> {
			String customerId = transanction.getCustomerId();
			if (!rewards.containsKey(customerId)) {
				rewards.put(customerId, new HashMap<>());
			}

			Map<String, Integer> customer_reward = rewards.get(customerId);
			Integer total = customer_reward.getOrDefault(transanction.getDate().getMonth().toString(), 0)
					+ calculateRewardPoints(transanction.getAmount());
			customer_reward.put(transanction.getDate().getMonth().toString(), total);
		});

		return rewards;
	}

	private int calculateRewardPoints(double amount) {
		// TODO Auto-generated method stub
		int point = 0;
		if (amount > 100) {
			point = point + (int) (2 * (amount - 100));
			amount = 100;
		}
		if (amount > 50) {
			point = point + (int) (amount - 50);
		}
		return point;
	}

}
