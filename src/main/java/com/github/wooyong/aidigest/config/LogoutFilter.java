package com.github.wooyong.aidigest.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LogoutFilter extends OncePerRequestFilter {
    private static final String LOGOUT_API = "/api/v1/auth/logout";
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // logout 요청이고 인증이 없으면 세션 무효화
        if (LOGOUT_API.equals(request.getRequestURI())
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        }

        filterChain.doFilter(request, response);
    }
}
