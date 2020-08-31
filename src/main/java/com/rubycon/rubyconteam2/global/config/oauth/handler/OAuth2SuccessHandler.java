package com.rubycon.rubyconteam2.global.config.oauth.handler;

import com.rubycon.rubyconteam2.global.config.security.SecurityConstants;
import com.rubycon.rubyconteam2.global.core.jwt.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        String id = authentication.getName();
        String name = oauth2User.getAttribute("name");
        String image = oauth2User.getAttribute("image");

        String token = jwtService.createToken(id, name);

        log.debug("Login Success : {} {} {}", id, name, image);
        log.debug("JWT token : {}", token);

        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);
        response.setContentType("application/json");
        response.getWriter().print(token);
    }
}