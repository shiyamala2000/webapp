import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String invalid = null;
        String pwd=null;
        String uname=null;
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        try (Connection con = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
            "root", "")) {
                String sql = "SELECT password,name FROM credintails WHERE  PASSWORD=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, password);
                ResultSet rset = statement.executeQuery();
                while(rset.next()){
                    pwd=rset.getString("password");
                    uname=rset.getString("name");
                }
                statement.close();
                rset.close();
                con.close();
            }
        catch(Exception e){
           System.out.println(e);
        }
        System.out.println(pwd+" "+uname);
        if (password.equals(pwd)&&name.equals(uname)) {
            invalid = "Welcome " + name;
            req.setAttribute("invalid", invalid);
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            req.getRequestDispatcher("Link.jsp").include(req, resp);
        } 
        else {
            invalid = "Invalid UserName or Password";
            req.setAttribute("invalid", invalid);
            req.getRequestDispatcher("Login.jsp").include(req, resp);
        }
    }
}