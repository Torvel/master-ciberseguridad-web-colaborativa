package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    
    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
    // Validación contra Path Traversal
    if (username == null || username.contains("..") || username.contains("/") || username.contains("\\")) {
        flash.put("error", "Nombre de usuario no válido");
        register();
        return;
    }

    User u = new User(username, HashUtils.getMd5(password), type, -1);
    u.save();
    registerComplete();
    }

    public static void registerComplete(){
        render();
    }

}
