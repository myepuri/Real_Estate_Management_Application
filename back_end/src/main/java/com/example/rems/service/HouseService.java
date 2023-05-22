package com.example.rems.service;

import com.example.rems.domain.HouseProperty;
import com.example.rems.entity.House;
import com.example.rems.repository.HouseRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class HouseService {

    @Resource
    private HouseRepo houseRepo;


    public List<HouseProperty> filterByLocationAndDate(String location, Date  startDate, Date endDate) {
        return houseRepo.findByLocationAndDate(location,startDate,endDate);
    }
}
