package org.example.helper;

import org.example.Entity.Product;

public class CheckProductNull {

    public boolean check(Product product){

        if ((product.getId() == null)
                | (product.getProductName() == null)
                | (product.getCategory() == null)
                | (product.getDescription() == null)
                | (product.getProducer() == null)
                | (product.getPrice() == null)
        ){
            return false;
        }
        return true;
    }

}
