package com.ineffable.shopfast1_5.Repositories;

import com.ineffable.shopfast1_5.Model.ServiceUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<ServiceUser, Long> {
    Optional<ServiceUser> findByUsername(String username);
}
