package com.gokul_auto_tech.backend_gokul_auto_tech.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Date;

@Service
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    private final HandlerExceptionResolver handlerExceptionResolver;

    @Autowired
    public JwtFilter(HandlerExceptionResolver handlerExceptionResolver) {
        this.handlerExceptionResolver = handlerExceptionResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        try {

            String bearerToken = request.getHeader("Authorization");

            assert bearerToken != null;
            String token = bearerToken.substring(7);

            String userEmailFromToken = jwtService.extractUserEmailFromToken(token);


            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmailFromToken);

            if (userEmailFromToken != null && jwtService.isTokenValid(token, userDetails)
                    && SecurityContextHolder.getContext().getAuthentication() == null
                    ) {

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);


        }catch (Exception ex){

            handlerExceptionResolver.resolveException(request, response, null, ex);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().contains("/gat/register")
                || request.getServletPath().contains("/gat/register/verify")
                || request.getServletPath().contains("/gat/authenticate")
                || request.getServletPath().contains("/gat/forgetpassword")
                || request.getServletPath().contains("/gat/forgetpassword/verify")
                || request.getServletPath().contains("/gat/forgetpassword/resetpassword");
    }
}
