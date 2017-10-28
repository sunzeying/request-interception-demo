package com.nextyu.demo.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 2017-10-28 16:29
 *
 * @author nextyu
 */
@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long startTime = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);

        long endTime = System.currentTimeMillis();
        System.out.println("time filter consume " + (endTime - startTime) + " ms");
        System.out.println("time filter end");
    }

    @Override
    public void destroy() {
        System.out.println("time filter init");
    }
}
