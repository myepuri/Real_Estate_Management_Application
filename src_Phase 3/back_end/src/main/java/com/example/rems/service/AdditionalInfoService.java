package com.example.rems.service;

import com.example.rems.entity.Additional_info;
import com.example.rems.repository.AdditionInfoRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Optional;

@Service
public class AdditionalInfoService {
    @Resource
    private AdditionInfoRepo additionInfoRepo;

    public Additional_info getInfoByPid(BigInteger pid){
        Optional<Additional_info> infoEntity = additionInfoRepo.findById(pid);
        return infoEntity.orElse(null);
    }

    public String addInfo(Additional_info additional_info){
        additionInfoRepo.save(additional_info);
        return "Success";
    }
}
