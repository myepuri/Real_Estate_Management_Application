package com.example.rems.service;

import com.example.rems.entity.Address;
import com.example.rems.repository.AddressRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddressService {
    @Resource
    private AddressRepo addressRepo;

    public String saveAddress(Address address){
      addressRepo.save(Address.builder().email(address.getEmail())
              .city(address.getCity())
              .state(address.getState())
              .zipcode(address.getZipcode())
              .build());
        return "Saved SuccessFully";
    }

    public Address getAddressByEmail(String email){
        return addressRepo.findByEmail(email);
    }

}
