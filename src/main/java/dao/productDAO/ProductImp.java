package dao.productDAO;

import com.mysql.cj.jdbc.CallableStatement;
import dao.ConnectionDB;
import models.Category;
import models.Product;
import models.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImp implements UIProduct {
    private ConnectionDB connectionDB = ConnectionDB.getInstance();

    @Override
    public List<Product> findAllProduct() {
        List<Product> productList = new ArrayList<>();

        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = (CallableStatement) connection.prepareCall(Query.FIND_ALL_PRODUCT);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("id");
                String nameProduct = resultSet.getString("nameProduct");
                long priceProduct = resultSet.getLong("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String nameCategory = resultSet.getString("nameCategory");

                Product product = new Product(idProduct, nameProduct, priceProduct, quantity,
                        color, new Category(nameCategory));

                productList.add(product);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public boolean deleteProductById(int id) {
        boolean result = false;
        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = (CallableStatement) connection.prepareCall(Query.DELETE_PRODUCT_BY_ID);
            callableStatement.setInt(1, id);

            result = callableStatement.executeUpdate() > 0;

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public Product findProductById(int id) {
        Product product = null;

        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = (CallableStatement) connection.prepareCall(Query.FIND_PRODUCT_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("id");
                String nameProduct = resultSet.getString("nameProduct");
                long priceProduct = resultSet.getLong("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String desc = resultSet.getString("description");
                String nameCategory = resultSet.getString("nameCategory");

                product = new Product(idProduct, nameProduct, priceProduct,
                        quantity, color, desc, new Category(nameCategory));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return product;
    }

    @Override
    public boolean updateProductById(int idProduct, String nameProduct, long price, int quantity,
                                     String color, String desc, int categoryId) {
        boolean result = false;
        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = (CallableStatement) connection.prepareCall(Query.UPDATE_PRODUCT_BY_ID);

            callableStatement.setInt(1, idProduct);
            callableStatement.setString(2, nameProduct);
            callableStatement.setLong(3, price);
            callableStatement.setInt(4, quantity);
            callableStatement.setString(5, color);
            callableStatement.setString(6, desc);
            callableStatement.setInt(7, categoryId);

            result = callableStatement.executeUpdate() > 0;

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }
}
