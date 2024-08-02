package com.retailer.reward.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailer.reward.entity.RewardTransaction;

public interface RewardsRepository extends JpaRepository<RewardTransaction, Long> {

}
