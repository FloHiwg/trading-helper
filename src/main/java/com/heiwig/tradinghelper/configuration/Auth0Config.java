package com.heiwig.tradinghelper.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class Auth0Config {
    @Value(value = "${com.auth0.domain}")
    String domain;

    @Value(value = "${com.auth0.clientId}")
    String clientId;

    @Value(value = "${com.auth0.clientSecret}")
    String clientSecret;

    @Bean
    public FilterRegistrationBean filterRegistration() {
        final FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new Auth0Filter());
        registration.addUrlPatterns("/portal/*");
        registration.setName(Auth0Filter.class.getSimpleName());
        return registration;
    }

    public String getDomain() {
        return domain;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
