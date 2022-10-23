package com.gmr.porfolio.services;

import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;

public class TokenSvc {
    @Autowired
    static
    JWTutil jwt;
     public boolean verifyToken(String token) {
        String userId = jwt.getKey(token);
        return userId != null;

    }
}
