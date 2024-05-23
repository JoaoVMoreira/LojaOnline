package com.LojaOnline.LojaOnline.Exceptions;

public class UserNotActivedException extends RuntimeException{
    public UserNotActivedException(){super("O usuário informado não está ativo");}
}
