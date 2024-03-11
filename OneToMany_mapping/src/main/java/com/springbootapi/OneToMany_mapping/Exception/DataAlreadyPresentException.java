package com.springbootapi.OneToMany_mapping.Exception;

public class DataAlreadyPresentException extends RuntimeException{
    String message;

    public DataAlreadyPresentException(String message)
    {
        super(message);
    }

}
