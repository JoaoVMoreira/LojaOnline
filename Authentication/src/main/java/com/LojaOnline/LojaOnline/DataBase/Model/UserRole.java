package com.LojaOnline.LojaOnline.DataBase.Model;

public enum UserRole {
    ADMIN("admini"),
    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
