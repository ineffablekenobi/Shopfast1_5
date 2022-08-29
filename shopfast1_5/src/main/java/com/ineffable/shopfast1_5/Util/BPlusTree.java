package com.ineffable.shopfast1_5.Util;

import com.ineffable.shopfast1_5.Model.Product;
import com.ineffable.shopfast1_5.Model.ServiceUser;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Component
public class BPlusTree {
    private Map<Long, Product> productCache;

    public BPlusTree(){
        productCache = new TreeMap<>();
    }

    public void insert(Long id, Product product){
        productCache.put(id,product);
    }

    public Boolean cacheHit(Long id){
        if(productCache.keySet().contains(id)){
            return true;
        }else {
            return false;
        }
    }

    public Product getUser(Long id){
         return productCache.get(id);
    }

}
