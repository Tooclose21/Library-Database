package com.example.technologiesieciowe.services;

import com.example.technologiesieciowe.entity.User;
import com.example.technologiesieciowe.filters.LoginForm;
import com.example.technologiesieciowe.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * The type Login service.
 */
@Service

public class LoginService {
    @Value("${jwt.token.key}")
    private String key;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Login string.
     *
     * @param loginFrom the login from
     * @return the string
     */
    public String login(LoginForm loginFrom){
        User user = userRepository.findByUsername(loginFrom.getUsername());
        if(passwordEncoder.matches(loginFrom.getPassword(), user.getPassword())){
            long timestamp = System.currentTimeMillis();

            String token = Jwts.builder()
                    .issuedAt(new Date(timestamp))
                    .expiration(new Date(timestamp + 5 * 60 * 1000))
                    .claim("id", user.getId())
                    .claim("userRole", user.getRole())
                    .signWith(SignatureAlgorithm.HS256, key)
                    . compact();
            return token;


        }
        return null;
    }

    /**
     * Instantiates a new Login service.
     *
     * @param passwordEncoder the password encoder
     * @param userRepository  the user repository
     */
    @Autowired
    public LoginService(PasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

    }
}
