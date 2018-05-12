package utility;

import entities.Users;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sinem
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();
        Users u = (Users) req.getSession().getAttribute("valid_user");

        if (u == null) {
            if (url.contains("admin") || url.contains("logout")) {
                res.sendRedirect(req.getContextPath()+"/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("register") || url.contains("login")) {
                res.sendRedirect(req.getContextPath()+"/admin/index.xhtml");
            } else if (url.contains("logout")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath()+"/frontend/index.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
