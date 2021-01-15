package dao;

import models.Product;

import java.util.List;

public interface UIProduct {
    List<Product> findAllProduct();
    boolean deleteProductById(int id);
    Product findProductById(int id);
}
