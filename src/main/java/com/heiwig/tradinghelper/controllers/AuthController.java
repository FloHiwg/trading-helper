package com.heiwig.tradinghelper.controllers;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.heiwig.tradinghelper.configuration.Auth0Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthController {

    private final AuthenticationController controller;

    @Autowired
    public AuthController(Auth0Config config) {
        JwkProvider jwkProvider = new JwkProviderBuilder((config.getDomain())).build();
        controller = AuthenticationController.newBuilder(config.getDomain(), config.getClientId(), config.getClientSecret())
                .withJwkProvider(jwkProvider)
                .build();
    }


    Tokens handle(HttpServletRequest request, HttpServletResponse response) throws IdentityVerificationException {
        return controller.handle(request, response);
    }

    String buildAuthorizeUrl(HttpServletRequest request, HttpServletResponse response, String redirectUri) {
        return controller
        .buildAuthorizeUrl(request, response, redirectUri)
        .build();
    }

}