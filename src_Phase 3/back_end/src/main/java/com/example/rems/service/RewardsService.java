package com.example.rems.service;

import com.example.rems.entity.Reward;
import com.example.rems.repository.RewardsRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RewardsService {
    @Resource
    private RewardsRepo rewardsRepo;


    public Integer getTotalPointsByEmail(String email) {
        List<Reward> rewards = rewardsRepo.findByEmail(email);

        return rewards.stream().mapToInt(Reward::getReward_point).reduce(0,Integer::sum);
    }
}
