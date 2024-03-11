package com.springbootapi.OneToMany_mapping.Exception;

public class DataNotPresentException extends Exception {

    String message;

    public DataNotPresentException(String message)
    {
        super(message);
    }

}
