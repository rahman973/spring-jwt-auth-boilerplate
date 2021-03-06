package br.com.thiagoft.springjwtauthboilerplate.module.core.model.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

public class User {

    private String username;
    private String password;
    private String email;
    private Date lastPasswordReset;
    private Date creationDate;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.creationDate = new Date();
        this.lastPasswordReset = this.creationDate;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Date getLastPasswordReset() {
        return lastPasswordReset;
    }

    public String getEncodedPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(this.password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
