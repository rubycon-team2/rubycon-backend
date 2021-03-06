package com.rubycon.rubyconteam2.global.config.oauth;

import com.rubycon.rubyconteam2.global.config.oauth.provider.CustomOAuth2Provider;
import com.rubycon.rubyconteam2.global.config.oauth.service.CustomOAuth2AuthorizedClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
@Slf4j
public class OAuth2Config {

    @Value("${custom.oauth2.kakao.client-id}")
    public String KAKAO_CLIENT_ID;
    @Value("${custom.oauth2.kakao.client-secret}")
    public String KAKAO_CLIENT_SECRET;

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService() {
        return new CustomOAuth2AuthorizedClientService();
    }

    // 기본으로 제공되지 않는 소셜 로그인들 등록
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(OAuth2ClientProperties oAuth2ClientProperties) {
        List<ClientRegistration> registrations = oAuth2ClientProperties.getRegistration().keySet().stream()
                .map(client -> getRegistration(oAuth2ClientProperties, client))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        registrations.add(CustomOAuth2Provider.KAKAO.getBuilder()
                .clientId(KAKAO_CLIENT_ID)
                .clientSecret(KAKAO_CLIENT_SECRET)
                .jwkSetUri("temp")
                .build());

        return new InMemoryClientRegistrationRepository(registrations);
    }

    // Spring이 기본으로 제공하는 소셜 로그인 기능 가져오기
    private ClientRegistration getRegistration(OAuth2ClientProperties clientProperties, String client) {
        if ("google".equals(client)) {
            OAuth2ClientProperties.Registration registration = clientProperties.getRegistration().get("google");
            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .scope(registration.getScope())
                    .build();
        } else if ("facebook".equals(client)) {
            OAuth2ClientProperties.Registration registration = clientProperties.getRegistration().get("facebook");
            OAuth2ClientProperties.Provider provider = clientProperties.getProvider().get("facebook");
            return CommonOAuth2Provider.FACEBOOK.getBuilder(client)
                    .clientId(registration.getClientId())
                    .clientSecret(registration.getClientSecret())
                    .userInfoUri(provider.getUserInfoUri())
                    .scope(registration.getScope())
                    .build();
        }

        return null;
    }

}
