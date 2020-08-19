package com.rubycon.rubyconteam2.domain.oauth.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2Controller {

    @GetMapping("/me")
    public String me(@AuthenticationPrincipal OAuth2User oAuth2User) {
        System.out.println(oAuth2User);
        return "My profile";
    }

    @GetMapping({"/loginSuccess", "/hello"})
    public String loginSuccess() {
        return "Hello Login Success !!";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }
}
