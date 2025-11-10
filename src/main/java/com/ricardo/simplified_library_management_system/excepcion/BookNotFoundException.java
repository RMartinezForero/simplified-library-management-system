package com.ricardo.simplified_library_management_system.excepcion;

public class BookNotFoundException extends RuntimeException{
    
    public BookNotFoundException(String message){
        super(message);
    }
}
