package dao.categoryDAO;

import com.mysql.cj.jdbc.CallableStatement;
import dao.ConnectionDB;
import models.Category;
import models.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryImp implements UICategory {

    private ConnectionDB connectionDB = ConnectionDB.getInstance();

    @Override
    public List<Category> findAllCategory() {

        List<Category> categoryList = new ArrayList<>();

        try {
            Connection connection = connectionDB.getConnection();
            CallableStatement callableStatement = (CallableStatement) connection.prepareCall(Query.FIND_ALL_CATEGORY);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");

                categoryList.add(new Category(id, nameCategory));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return categoryList;
    }
}
