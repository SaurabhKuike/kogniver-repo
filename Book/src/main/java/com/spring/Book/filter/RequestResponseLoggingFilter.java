package com.spring.Book.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Slf4j
@Order(2)
public class RequestResponseLoggingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init((jakarta.servlet.FilterConfig) filterConfig);
        log.info("Initializing Filter {}",this);

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;
        log.info("Starting filter with url {}",httpServletRequest.getRequestURL());
        chain.doFilter(request,response);
        log.info("Ending Filter with path {}",httpServletRequest.getRequestURL());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("Destroying Filter {}",this);
    }
}
