package com.ecomerce.Service;

import com.ecomerce.Model.Category;
import com.ecomerce.Model.User;
import com.ecomerce.Repo.ProductRepo;
import com.ecomerce.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;


    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);

    }

    public List<Category> getHomePageProducts(List<String> homelist) {
        List<Category> categories = new ArrayList<Category>();
        for (String cat : homelist) {
            Category category = new Category();
            category.setName(cat);
            category.setProducts(productRepo.findByCategories(cat));
            categories.add(category);
        }
        return categories;
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

}
