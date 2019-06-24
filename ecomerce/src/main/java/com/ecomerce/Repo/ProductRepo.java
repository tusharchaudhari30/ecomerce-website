package com.ecomerce.Repo;

import com.ecomerce.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ProductRepo extends MongoRepository<Product,String>
{
    List<Product> findByCatagories(String catagories);
}
