package com.ecom.users.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String correlationId = request.getHeader("X-Correlation-ID");

        System.out.println(
                "Request URL: " + request.getMethod() + " " + request.getRequestURI()
        );
        System.out.println("Correlation ID: " + correlationId);
        filterChain.doFilter(request, response);

        System.out.println("Response Status: " + response.getStatus());

    }
}
