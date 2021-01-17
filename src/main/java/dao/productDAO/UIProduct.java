package dao.productDAO;

import models.Product;

import java.util.List;

public interface UIProduct {
    List<Product> findAllProduct();
    boolean deleteProductById(int id);
    Product findProductById(int id);
    boolean updateProductById(int idProduct,String nameProduct,
                              long price, int quantity, String color,
                              String desc, int categoryId);
}
