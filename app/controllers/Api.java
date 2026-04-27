package controllers;


import com.google.gson.JsonObject;
import models.Constants;
import models.User;
import play.mvc.Controller;

public class Api extends Controller {

    public static void removeAllUsers(){
        if (!session.contains("username")) {
            forbidden();
        }
        
        User u = User.loadUser(session.get("username"));
        if (u == null || !u.getType().equals(Constants.User.TEACHER)) {
            forbidden();
        }

        User.removeAll();
        renderJSON(new JsonObject());
    }
}
