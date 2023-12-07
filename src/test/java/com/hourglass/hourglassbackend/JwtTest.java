package com.hourglass.hourglassbackend;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","sheeep");
        String token=JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60*12 ))
                .sign(Algorithm.HMAC256("littlesheeeeep"));

        System.out.println(token);
    }

    @Test
    public void testParse(){
        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Im5hbWUiOiJzaGVlZXAiLCJpZCI6MX0sImV4cCI6MTcwMTk3ODkwM30.CcMDP2rxN0eMzxFRnkth5dxkQ95Dn4JcVvmFsOTQqBI";
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256("littlesheeeeep")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims= decodedJWT.getClaims();
        System.out.println(claims.get("user").asMap());
    }
}
