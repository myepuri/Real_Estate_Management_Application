package com.example.rems.service;

import com.example.rems.domain.UserDetails;
import com.example.rems.entity.Users;
import com.example.rems.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UsersService {


    @Resource
    private UserRepo userRepo;

    public String registerService(UserDetails userDetails) {
        userRepo.save(Users.builder().email(userDetails.getEmail())
                .password(userDetails.getPassword())
                .user_type(userDetails.getUser_type())
                .name(userDetails.getName()).build());

        return "User/Agent Added SuccesFully";
    }

    public String loginService(UserDetails userDetails) {
        Optional<Users> usersEntity = userRepo.findByEmail(userDetails.getEmail());

        if (usersEntity.isPresent()){
            Users users = usersEntity.get();
            if (users.getPassword().equals(userDetails.getPassword()) && users.getUser_type().equals(userDetails.getUser_type())){
                return users.getUser_type();
            }else {
                return "Invalid";
            }
        }else {
            return "User Doesnt exist / Register yourself";
        }
    }
}
