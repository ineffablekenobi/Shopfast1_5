package com.ineffable.shopfast1_5.Services;

import com.ineffable.shopfast1_5.Model.ServiceUser;
import com.ineffable.shopfast1_5.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public ServiceUser login(ServiceUser serviceUser) throws IllegalAccessException{
        Optional<ServiceUser> user = userRepo.findByUsername(serviceUser.getUsername());
        if(user.isEmpty()){
            throw new IllegalAccessException();
        }else{
            if(!user.get().getPassword().equals(serviceUser.getPassword())){
                throw new IllegalAccessException();
            }else{
                return user.get();
            }
        }
    }

}
