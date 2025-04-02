package ch.csbe.productstore.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    // PLEASE USE A MORE SECURE KEY :-)
    private final String SECRET_KEY = "slakdjflkjsdflkjsfjsjfsafffspadfsadfjisncinsoiujfaisfposiajdcjiodsanfiofnaisfnpasdhfsadfsdaijfijsdaifjpsadjfiiwjwioajffsdifpo";


    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("roles", user.getRole())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
