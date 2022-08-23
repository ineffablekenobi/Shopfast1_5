package com.ineffable.shopfast1_5.Repositories;

import com.ineffable.shopfast1_5.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
}
