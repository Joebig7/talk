package com.mamba.talk.filter;

import com.mamba.talk.controller.constant.UserConstant;
import com.mamba.talk.model.bean.UserBean;
import com.mamba.talk.service.UserServiceImpl;
import com.mamba.talk.util.StringUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author JoeBig7
 * @date 2021/3/2 09:45:38
 * @description 权限过滤器 如果已经登录则直接放行，并且将cookie的过期时间重置为半小时
 */
public class AuthenticationFilter implements Filter {
    private static final String LOGIN_PATH = "/user/login";

    private static final String LOGIN_PAGE_PATH = "/login.html";

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String contextPath = httpServletRequest.getServletContext().getContextPath();

        if (!LOGIN_PATH.equals(contextPath) && !LOGIN_PAGE_PATH.equals(contextPath)) {
            //判断是否已经登录
            Cookie[] cookies = httpServletRequest.getCookies();

            boolean flag = false;

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(UserConstant.TOKEN)) {
                    String token = cookie.getValue();
                    if (!StringUtil.isBlank(token)) {
                        flag = true;
                        String[] userInfo = token.split("-");
                        String pwd = userInfo[0];
                        String userName = userInfo[1];

                        UserBean user = userService.findUserByUserName(userName);
                        if (Objects.nonNull(user) && pwd.equals(user.getPassword())) {
                            cookie.setMaxAge(UserConstant.COOKIE_EXPIRE_SECOND);
                        }
                        filterChain.doFilter(httpServletRequest, httpServletResponse);
                    }
                }
            }

            if (flag == false) {
                httpServletRequest.getRequestDispatcher("/login.html").forward(httpServletRequest, httpServletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
