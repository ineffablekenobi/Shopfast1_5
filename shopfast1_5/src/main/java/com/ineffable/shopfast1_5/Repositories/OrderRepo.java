package com.ineffable.shopfast1_5.Repositories;

import com.ineffable.shopfast1_5.Model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Orders, Long> {

}
