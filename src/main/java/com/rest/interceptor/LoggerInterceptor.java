package com.rest.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Log4j2
public class LoggerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("[preHandle]" + "[" + request.getMethod()
                + "]" + request.getRequestURI() + "[" + getQuery(request) + "]");
        return true;
    }

    private String getQuery(HttpServletRequest request) {
        String queryString = request.getQueryString();
        if (queryString != null) {
            return "?" + queryString;
        }
        return "";
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("[postHandle]" + "[status-> " + response.getStatus() + "]" + getHeaders(response));
    }

    private String getHeaders(HttpServletResponse response) {
        StringBuilder stringBuilder = new StringBuilder();
        response.getHeaderNames()
                .forEach(s -> stringBuilder.append("[").append(s).append("-> ").append(response.getHeader(s)).append("]"));
        return stringBuilder.toString();
    }
}
