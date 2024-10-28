package org.clevertech.servlet.pz.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/v1/cars/*"})
public class PlatformKeyFilter implements Filter {

    private static String platformKey = "Y2FyUGxhdGZvcm0=";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        if (!platformKey.equals(servletRequest.getParameter("platformKey"))) {
            throw new ServletException("Invalid platformKey");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
