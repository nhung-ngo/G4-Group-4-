package com.csc340.crudAPI.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String redirectURL = request.getContextPath();

        if (authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            redirectURL = "/ADMIN/all";
        } else if (authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_USER"))) {
            redirectURL = "/user/home";
        }

        response.sendRedirect(redirectURL);
    }
}

