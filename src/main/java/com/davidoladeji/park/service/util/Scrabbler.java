package com.davidoladeji.park.service.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Daveola on 3/5/2015.
 */
public class Scrabbler {

    public String encrypt(String password) {

        if (password.length() >= 6) {

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            String hashedPassword = passwordEncoder.encode(password);

            password = hashedPassword;
        } else {
            throw new IllegalArgumentException("Password length must be more than 6 characters");
        }

        return password;
    }
    
    public static void main(String[] args){
    	System.out.println(new Scrabbler().encrypt("rutul123"));
    }
}
