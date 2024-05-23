package com.LojaOnline.LojaOnline.Exceptions;

public class RepeatedAttributeException extends RuntimeException{
    public RepeatedAttributeException(){super("Atributo repetido ao cadastrar usuário");}

    public RepeatedAttributeException(String message){super(message);}
}
