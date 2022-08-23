package com.ineffable.shopfast1_5.Services;

import com.ineffable.shopfast1_5.Model.ServiceUser;
import com.ineffable.shopfast1_5.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public ServiceUser getByUsername(String username){
        return userRepo.findByUsername(username).get();
    }

    public ServiceUser createUser(ServiceUser serviceUser){
        return userRepo.save(serviceUser);
    }

    public ServiceUser updateUser(ServiceUser serviceUser){
        if(serviceUser.getId() == null){
            return serviceUser;
        }
        return userRepo.save(serviceUser);
    }

}
