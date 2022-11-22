package com.shayariwayari.app.ws.user.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = 3837333537357229L;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus;
}
