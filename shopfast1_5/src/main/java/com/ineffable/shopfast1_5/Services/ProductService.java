package com.ineffable.shopfast1_5.Services;

import com.ineffable.shopfast1_5.Model.Orders;
import com.ineffable.shopfast1_5.Model.Product;
import com.ineffable.shopfast1_5.Model.Variant;
import com.ineffable.shopfast1_5.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product create(Product product){
        List<Variant> variantList = new ArrayList<>( product.getVariantList());
        product.getVariantList().clear();
        Product savedProduct = productRepo.save(product);

        for(Variant variant : variantList){
         variant.getVid().setPid(savedProduct.getProductid());
        }

        savedProduct.setVariantList(variantList);
        return productRepo.save(savedProduct);
    }

    public List<Product> getAll(){
        List<Product> productList = new ArrayList<>();
        productRepo.findAll().forEach(productList::add);
        return productList;
    }

    public Product getProductById(Long id){
        return productRepo.findById(id).get();
    }

}
