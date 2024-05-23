package com.LojaOnline.LojaOnline.Exceptions;

public class RecoverTokenNullException extends RuntimeException{
    public RecoverTokenNullException(){super("Token recuperado é nulo");}
}
