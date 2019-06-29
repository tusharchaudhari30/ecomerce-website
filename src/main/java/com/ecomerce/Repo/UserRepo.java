package com.ecomerce.Repo;

import com.ecomerce.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository <User,String> {
    User findUserByEmail(String email);

}
