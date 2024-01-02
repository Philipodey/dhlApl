package com.logisticsapp.redstar.exceptions;

public class InvalidDetailsException extends LogisticsException{

    public InvalidDetailsException() {
        super("Login credentials is invalid !!");
    }
}
