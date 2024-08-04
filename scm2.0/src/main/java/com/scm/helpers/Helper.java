package com.scm.helpers;

import org.springframework.data.jpa.repository.query.JSqlParserUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;

import java.security.Principal;

public class Helper {
    public static String getEmailOfLoggedInUser(Authentication authentication) {

        //email and password
        if(authentication instanceof OAuth2AuthenticatedPrincipal) {
            var oAuth2AuthenticationToken =   (OAuth2AuthenticationToken)authentication;
            var clientId = oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

            if (clientId.equalsIgnoreCase("google")) {
                //google
                System.out.println("Getting from Google");
            } else if (clientId.equalsIgnoreCase("github")) {
                //github
                System.out.println("Getting from Github");
            }

            return "";
        }

        else {
            System.out.println("Getting data from local database");
            return authentication.getName();
        }
    }
}
