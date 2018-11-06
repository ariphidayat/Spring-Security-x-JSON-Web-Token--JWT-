package id.arip.config;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Arip Hidayat on 11/6/2018.
 */
@Component
public class AccessTokenConverterEx extends DefaultAccessTokenConverter {

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
       OAuth2Authentication auth = super.extractAuthentication(claims);
       auth.setDetails(claims);
       return auth;
    }
}
