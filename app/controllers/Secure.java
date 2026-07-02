package controllers;


import helpers.HashUtils;
import models.User;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Http;

public class Secure extends Controller {

    public static void login(){
        render();
    }

    public static void logout(){
        session.remove("password");
        login();
    }

    public static void authenticate(String username, String password){
        if (request.method.equals("GET")) {
            badRequest(); 
        }

        checkAuthenticity();

        User u = User.loadUser(username);
        if (u != null && u.getPassword().equals(HashUtils.getMd5(password))){
            session.put("username", username);
            Application.index();
        }else{
            flash.put("error", Messages.get("Public.login.error.credentials"));
            login();
        }

    }
}
