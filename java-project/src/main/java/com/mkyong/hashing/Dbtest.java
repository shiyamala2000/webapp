package com.mkyong.hashing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dbtest {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/assessmentshiyamdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
        "root", "");
        List<Books> l=new ArrayList<Books>();
        
        
        // String strSelect = "select title, price, qty from books";
        // ResultSet rs = stmt.executeQuery(strSelect);
        //count
        Statement s = con.createStatement();
        ResultSet r=s.executeQuery("select count(id) as total from books");
        while(r.next())
          System.out.println(r.getString("total"));
        //select
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from books");
        while(rs.next()) {
            // String title = rs.getString("title");  // retrieve a 'String'-cell in the row
            // double price = rs.getDouble("price");  // retrieve a 'double'-cell in the row
            // int    qty   = rs.getInt("qty");       // retrieve a 'int'-cell in the row
            // System.out.println(title + ", " + price + ", " + qty);
           // ++rowCount;
           l.add(new Books(rs.getInt("id"),rs.getString("title"),rs.getString("author"),rs.getFloat("price"),rs.getInt("qty")));
        }
        System.out.println(l);
        //update
        Statement stm = con.createStatement();
        int executeUpdate = stm.executeUpdate("update books set author='Harry Potter' where id=1005");
        System.out.println(executeUpdate);
        con.close();
        System.out.println(l);
        //delete
        // String sql = "DELETE FROM Registration " +"WHERE id = 101";
        // stmt.executeUpdate(sql);
    }
    
}
