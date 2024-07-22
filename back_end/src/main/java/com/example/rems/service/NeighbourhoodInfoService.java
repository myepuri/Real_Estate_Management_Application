package com.example.rems.service;

import com.example.rems.entity.NeighbourhoodInfo;
import com.example.rems.repository.NeighbourhoodInfoRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Optional;

@Service
public class NeighbourhoodInfoService {
    @Resource
    private NeighbourhoodInfoRepo neighbourhoodInfoRepo;

    public NeighbourhoodInfo getInfoByPid(BigInteger pid){
        Optional<NeighbourhoodInfo> infoEntity = neighbourhoodInfoRepo.findById(pid);
        return infoEntity.orElse(null);
    }

    public  String addNeighbourHoodInfo(NeighbourhoodInfo neighbourhoodInfo){
        neighbourhoodInfoRepo.save(neighbourhoodInfo);
        return "Success";
    }
}
