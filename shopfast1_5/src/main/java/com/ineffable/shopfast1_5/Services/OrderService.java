package com.ineffable.shopfast1_5.Services;

import com.ineffable.shopfast1_5.DTO.OrderRequest;
import com.ineffable.shopfast1_5.Model.Orders;
import com.ineffable.shopfast1_5.Model.Product;
import com.ineffable.shopfast1_5.Model.ServiceUser;
import com.ineffable.shopfast1_5.Model.SubOrder;
import com.ineffable.shopfast1_5.Repositories.OrderRepo;
import com.ineffable.shopfast1_5.Repositories.SubOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SubOrderRepo subOrderRepo;

    @Autowired
    private OrderRepo orderRepo;

    public Orders create(OrderRequest orderRequest){
        ServiceUser serviceUser = userService.getByUsername(orderRequest.getUsername());
        Orders orders = new Orders();
        orders.setLastUpdated(new Date());
        orders.setStatus("Pending");
        for(Map.Entry<Long,Long> entry : orderRequest.getSubOrders().entrySet() ){
            Product product = productService.getProductById(entry.getKey());
            SubOrder subOrder = new SubOrder();
            subOrder.setProduct(product);
            subOrder.setQuantity(entry.getValue());
            subOrderRepo.save(subOrder);
            orders.getSubOrderList().add(subOrder);
        }

        orderRepo.save(orders);
        serviceUser.getOrdersList().add(orders);
        userService.updateUser(serviceUser);

        return orders;
    }

    public List<Orders> getAll(){
        List<Orders> ordersList = new ArrayList<>();
        orderRepo.findAll().forEach(ordersList::add);
        return ordersList;
    }

}
