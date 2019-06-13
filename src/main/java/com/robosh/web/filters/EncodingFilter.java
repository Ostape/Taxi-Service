package com.robosh.web.filters;


import javax.servlet.*;
import java.io.IOException;

/**
 * This filter respond for encoding on jsp pages and database
 *
 * @author Orest Shemelyuk
 */
public class EncodingFilter implements Filter {

    private static final String ENCODING_TYPE = "encoding_type";
    private static final String CONTENT_TYPE = "text/html; charset=";
    private String encodingTypeValue;


    @Override
    public void init(FilterConfig filterConfig) {
        encodingTypeValue = filterConfig.
                getInitParameter(ENCODING_TYPE);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encodingTypeValue);
        servletResponse.setCharacterEncoding(encodingTypeValue);
        servletResponse.setContentType(CONTENT_TYPE + encodingTypeValue);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}