package com.retailer.reward;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.retailer.reward.controller.RewardCalculationController;
import com.retailer.reward.dto.RewardsResponseDTO;
import com.retailer.reward.service.RewardCalculationService;

public class RewardCalculationTest {

	private MockMvc mockMvc;

	@Mock
	private RewardCalculationService rewardCalculationService;

	@InjectMocks
	private RewardCalculationController rewardCalculationController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(rewardCalculationController).build();
	}

	@Test
	public void calculate_reward_points() throws Exception {

		List<RewardsResponseDTO> mockRewards = new ArrayList<>();
		mockRewards.add(new RewardsResponseDTO(1, "Roxy", 2024, null, 950.0));
		Mockito.when(rewardCalculationService.calculateRewards()).thenReturn(mockRewards);

		mockMvc.perform(get("/api/reward").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.message").value("Data Retrieved Successfully."))
				.andExpect(jsonPath("$.data[0].name").value("Roxy")).andExpect(jsonPath("$.data[0].year").value(2024))
				.andExpect(jsonPath("$.data[0].monthAndPoints").isEmpty())
				.andExpect(jsonPath("$.data[0].totalPoints").value(950.0));

	}

}
