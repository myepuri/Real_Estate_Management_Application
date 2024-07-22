package com.example.rems.service;

import com.example.rems.domain.RenterDetails;
import com.example.rems.entity.Renter;
import com.example.rems.repository.AddressRepo;
import com.example.rems.repository.Renterrepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RenterService {

    @Resource
    private Renterrepo renterrepo;

    @Resource
    private AddressRepo addressRepo;

    public String addRenter(RenterDetails renterDetails) {
        Renter renter = Renter.builder().rid(renterDetails.getRid()).budget(renterDetails.getBudget())
                .move_in_date(renterDetails.getMove_in_date()).name(renterDetails.getName()).preferred_location(renterDetails.getPreferred_location()).build();
        renterrepo.save(renter);

        return "Success";
    }

    public String deleteRenter(String email){
        renterrepo.deleteByRid(email);
        addressRepo.deleteByEmail(email);

        return "Renter Deleted Successfully";
    }

    public Renter getRenterDetails(String email){
        return renterrepo.findByRid(email);
    }
}
