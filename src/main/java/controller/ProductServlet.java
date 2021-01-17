package controller;

import dao.categoryDAO.CategoryImp;
import dao.categoryDAO.UICategory;
import dao.productDAO.ProductImp;
import dao.productDAO.UIProduct;
import models.Category;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private UIProduct imp = new ProductImp();
    private UICategory impCategory = new CategoryImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            default:
                displayListProduct(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "delete":
                deleteProduct(req, resp);
                break;
            case "edit":
                saveProduct(req, resp);
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int productId = Integer.parseInt(req.getParameter("id"));
        boolean valid = imp.deleteProductById(productId);
        if(valid){
            System.out.println("delete success");
            resp.sendRedirect("product");
        }
    }

    private void saveProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idProduct = Integer.parseInt(req.getParameter("id"));
        String nameProduct = req.getParameter("nameProduct");
        long price = Long.parseLong(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String desc = req.getParameter("desc");
        int categoryId = Integer.parseInt(req.getParameter("selectCategory"));

        boolean valid = imp.updateProductById(idProduct, nameProduct, price, quantity,
                color, desc, categoryId);
        if(valid){
            resp.sendRedirect("product");
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProduct = Integer.parseInt(req.getParameter("id"));
        Product product = imp.findProductById(idProduct);
        List<Category> categoryList = impCategory.findAllCategory();
        req.setAttribute("product", product);
        req.setAttribute("categoryList",categoryList);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    private void displayListProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = imp.findAllProduct();

        req.setAttribute("productList", productList);
        req.getRequestDispatcher("show.jsp").forward(req, resp);
    }
}
