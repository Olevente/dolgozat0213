package controllers;

import java.util.ArrayList;
import java.util.Arrays;

import models.Builders;
import models.Restapi;
import views.MainView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.scene.effect.GlowBuilder;





public class Maincontroller {
    MainView mainView;
    
    public Maincontroller() 
    {
        this.mainView = new MainView();
        this.showData();
    }

    private void showData() {
        Restapi restapi = new Restapi();
        String res = restapi.getOlev();
        ArrayList<Builders> fList = convertStringToArray(res);
        this.mainView.printolev(fList);
    }

    private ArrayList<Builders> convertStringToArray(String res) {
        ArrayList<Builders>fList = null;
        GsonBuilder builder = new GlowBuilder();
        Gson gson = builder.create();
        Builders[] fantArray = gson.fromJson(res,Builders[].class);
        fList = new ArrayList<>(Arrays.asList(fantArray));
        return fList;
    }
}
