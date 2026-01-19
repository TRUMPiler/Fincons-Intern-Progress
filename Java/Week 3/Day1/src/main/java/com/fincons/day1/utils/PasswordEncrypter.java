package com.fincons.day1.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class PasswordEncrypter {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public PasswordEncrypter()
    {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }


    public String passwordEncryptor(String Password)
    {
        return bCryptPasswordEncoder.encode(Password);
    }
    public boolean checkPassword(String Password, String EncryptedPassword)
    {
        return bCryptPasswordEncoder.matches(Password, EncryptedPassword);
    }
}
