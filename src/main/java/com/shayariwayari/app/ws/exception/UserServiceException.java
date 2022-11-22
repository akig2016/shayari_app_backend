package com.shayariwayari.app.ws.exception;

public class UserServiceException extends RuntimeException{
    public static final long serialVersionUID = 7456209780369480807L;
    public UserServiceException(String message){
        super(message);

    }
}
