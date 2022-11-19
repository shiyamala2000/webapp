package com.kgisl.book.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgisl.book.entity.Product;
//import com.mysql.cj.xdevapi.Statement;
//@WebServlet("/product")

public class ProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("product Controller Do Get");

        String action = req.getServletPath();
        System.out.println(action);

        switch (action) {
            case "/new":
                showNewForm(req, resp);
                break;
            case "/insert":
                insertProduct(req, resp);
                break;
            case "/delete":
                deleteProduct(req, resp);
                break;
            case "/edit":
                showEditForm(req, resp);
                break;
            case "/update":
                updateProduct(req, resp);
                break;
            default:
                listProduct(req, resp);
                break;
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int product_id = Integer.parseInt(req.getParameter("product_id"));
            //System.out.println(product_id);
            
            String product_name = req.getParameter("product_name");
            String product_quantity = req.getParameter("product_quantity");
            float product_price = Float.parseFloat(req.getParameter("product_price"));
            String pro_manufactured_date = req.getParameter("pro_manufactured_date");
            String pro_expiry_date = req.getParameter("pro_expiry_date");

            Product products = new Product(product_id, product_name, product_quantity, product_price, pro_manufactured_date, pro_expiry_date);
            String sql = "UPDATE product SET product_name = ?,product_quantity =?, product_price = ?, pro_manufactured_date = ?,pro_expiry_date =? ";
            sql += " WHERE product_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, products.getProduct_name());
            statement.setString(2, products.getProduct_quantity());
            statement.setFloat(3, products.getProduct_price());
            statement.setString(4, products.getPro_manufactured_date());
            statement.setString(5, products.getPro_expiry_date());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int pro_id = Integer.parseInt(req.getParameter("product_id"));
           
            String sql = "SELECT * FROM product WHERE product_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, pro_id);
            ResultSet resultSet = statement.executeQuery();
            Object products = null;
            if (resultSet.next()) {
                String product_name = resultSet.getString("product_name");
                String product_quantity = resultSet.getString("product_quantity");
                float product_price = resultSet.getFloat("product_price");
                String pro_manufactured_date = resultSet.getString("pro_manufactured_date");
                String pro_expiry_date = resultSet.getString("pro_expiry_date");
                 products = new Product(product_name, product_quantity, product_price, pro_manufactured_date,
                        pro_expiry_date);
            }
            resultSet.close();
            statement.close();
            con.close();
            RequestDispatcher dispatcher = req.getRequestDispatcher("ProductForm.jsp");
           
            req.setAttribute("products", products);
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int product_id = Integer.parseInt(req.getParameter("product_id"));
            System.out.println(product_id);

            Product products = new Product(product_id, null, null, 0, null, null);
            String sql = "DELETE FROM product where product_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, products.getProduct_id());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            //int product_id = req.getin
            String product_name = req.getParameter("product_name");
            String product_quantity = req.getParameter("product_quantity");
            float product_price = Float.parseFloat(req.getParameter("product_price"));
            String pro_manufactured_date = req.getParameter("pro_manufactured_date");
            String pro_expiry_date = req.getParameter("pro_expiry_date");

            Product product = new Product(product_name, product_quantity, product_price, pro_manufactured_date, pro_expiry_date);
            String sql = "INSERT INTO product(product_name, product_quantity, product_price, pro_manufactured_date, pro_expiry_date) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, product.getProduct_name());
            statement.setString(2, product.getProduct_quantity());
            statement.setFloat(3, product.getProduct_price());
            statement.setString(4, product.getPro_manufactured_date());
            statement.setString(5, product.getPro_expiry_date());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("ProductForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {

            ArrayList<Product> productlist = new ArrayList<Product>();
            java.sql.Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from product");
            while (rset.next()) {
                productlist.add(new Product(rset.getInt("product_id"), rset.getString("product_name"),
                        rset.getString("product_quantity"),
                        rset.getFloat("product_price"), rset.getString("pro_manufactured_date"),
                        rset.getString("pro_expiry_date")));
            }
            // String s = "BatMan";
            // req.setAttribute("s", s);
            stmt.close();
            con.close();
            req.setAttribute("productlist", productlist);
            RequestDispatcher dis = req.getRequestDispatcher("ProductList.jsp");
            dis.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
