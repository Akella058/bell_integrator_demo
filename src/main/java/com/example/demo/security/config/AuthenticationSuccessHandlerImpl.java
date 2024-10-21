package com.example.demo.security.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

public class AuthenticationSuccessHandlerImpl  implements AuthenticationSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger("AuthenticationSuccessHandlerImpl");

    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/users");
    SimpleUrlAuthenticationSuccessHandler userSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/c_orders");

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {
            String authorityName = grantedAuthority.getAuthority();
            switch (authorityName) {
                case "ADMIN":
                    this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                    LOGGER.info("Пользователь с ролью ADMIN залогинился");
                    return;
                default:
                    this.userSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                    LOGGER.info("Пользователь с ролью CUSTOMER залогинился");
            }
        }
    }
}
