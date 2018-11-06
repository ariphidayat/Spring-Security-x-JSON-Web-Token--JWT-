package id.arip.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arip Hidayat on 11/6/2018.
 */
public class TokenEnhancerEx implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication auth) {
        Map<String, Object> map = new HashMap<>();
        map.put("developer", "Arip Hidayat");

        DefaultOAuth2AccessToken accessTokenEx = (DefaultOAuth2AccessToken) accessToken;
        accessTokenEx.setAdditionalInformation(map);

        return accessTokenEx;
    }
}
