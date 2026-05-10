package controllers;


import com.mysql.cj.Constants;

import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    
    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck){
        User u = new User(username, HashUtils.getMd5(password), models.Constants.User.STUDENT, -1);
        u.save();
        registerComplete();
    }

    public static void registerComplete(){
        render();
    }

}
