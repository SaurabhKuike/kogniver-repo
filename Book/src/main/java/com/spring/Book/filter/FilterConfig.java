package com.spring.Book.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingfilter(){
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean=new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestResponseLoggingFilter());
        registrationBean.addUrlPatterns("/api/**");
        return registrationBean;
    }
}
