import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/servlet1")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        PrintWriter out = resp.getWriter();
        String password = req.getParameter("password");
        if (password.equals("admin")) {
            chain.doFilter(req, resp);// sends request to next resource
        } else {
            String invalid = "Username or Password error!";
            req.setAttribute("invalid", invalid);
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.include(req, resp);
        }

    }

    @Override
    public void destroy() {
    }

}
