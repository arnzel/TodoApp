package controllers;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import models.User;
import play.Logger;
import play.data.validation.Error;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;

/**
 * Created by arne on 30.06.17.
 */
public class Users extends Controller {

    public static void newUser() {
        render("user/newUser.html");
    }

    public static void all() {
        List<User> users = User.all().fetch();
        render("user/allUser.html", users);
    }

    public static void allJson() {
        List<User> users = User.all().fetch();
        renderJSON(users);
    }

    public static void save(@Valid User user, @Valid String confirmationPassword) {
        System.out.println(user.toString());
        if (!user.password.equals(confirmationPassword)) {
            Validation.addError("confirmationPassword","passwords are not the same");
        }
        if (validation.hasErrors()) {
            params.flash(); 
            validation.keep(); 
            newUser();
        }

        user.save();
        all();
    }
    
    public static void saveJson() {
    	User newUser = new Gson().fromJson(new InputStreamReader(request.body), User.class);
    	newUser.save();
    }
    
    public void deleteUser(long id) {
    	User.delete("id", id);
    }

    public void deleteAllUser() {
        User.deleteAll();

    }
}
