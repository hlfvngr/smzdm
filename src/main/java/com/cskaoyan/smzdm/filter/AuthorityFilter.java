package com.cskaoyan.smzdm.filter;

import com.cskaoyan.smzdm.bean.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthorityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURI = req.getRequestURI();

        if(requestURI.matches(".*/user/.*")
                || requestURI.endsWith("/logout")
                || requestURI.endsWith("/addComment")
                || requestURI.endsWith("/like")
                || requestURI.endsWith("/dislike")){
            HttpSession session = req.getSession(false);
            if(session != null){
                User user = (User) session.getAttribute("user");
                if(user != null){
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }else {
                    servletResponse.getWriter().println("请先<a href=" + req.getContextPath() + "/home>登录</a>再访问!");
                    return;
                }
            }else {
                servletResponse.getWriter().println("请先<a href=" + req.getContextPath() + "/home>登录</a>再访问!");
                return;
            }
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
