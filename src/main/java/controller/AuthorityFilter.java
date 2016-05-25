package controller;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//权限验证过滤器
/**
 * Created by cqx on 2016/5/15.
 */
public class AuthorityFilter implements Filter {


    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        System.out.print("???????????????????????????");
        HttpServletRequest req = (HttpServletRequest) arg0;
        HttpServletResponse res = (HttpServletResponse) arg1;
        String request_uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String uri = request_uri.substring(contextPath.length());
        if (req.getSession().getAttribute("username") == null) {
            if (uri.equals("/login.jsp") || request_uri.indexOf("css/") > 0
                    || request_uri.indexOf("img/") > 0
                    || request_uri.indexOf("js/") > 0
                    || uri.equals("/login.action")) {
                arg2.doFilter(arg0, arg1);
                return;
            }
            else
            {
                //res.sendRedirect("/openfund/login.jsp");
                System.out.println("/login.jsp !!");
                req.getRequestDispatcher("/login.jsp").forward(req, res);
            }
        }
        else arg2.doFilter(arg0, arg1);

    }


    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}
