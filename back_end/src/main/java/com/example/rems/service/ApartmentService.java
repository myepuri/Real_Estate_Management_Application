package com.example.rems.service;

import com.example.rems.domain.HouseProperty;
import com.example.rems.repository.AppartmentRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ApartmentService {

    @Resource
    private AppartmentRepo appartmentRepo;

    public List<HouseProperty> filterByLocationAndDate(String location, Date startDate, Date endDate) {
        return appartmentRepo.findByLocationAndDate(location,startDate,endDate);
    }
}
