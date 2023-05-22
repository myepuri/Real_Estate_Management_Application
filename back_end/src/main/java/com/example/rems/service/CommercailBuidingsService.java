package com.example.rems.service;

import com.example.rems.domain.CommercailProperty;
import com.example.rems.domain.HouseProperty;
import com.example.rems.repository.CommercialBuildingsRepo;
import com.example.rems.repository.HouseRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CommercailBuidingsService {

    @Resource
    private CommercialBuildingsRepo commercialBuildingsRepo;


    public List<CommercailProperty> filterByLocationAndDate(String location, Date  startDate, Date endDate) {
        return commercialBuildingsRepo.findByLocationAndDate(location,startDate,endDate);
    }
}
