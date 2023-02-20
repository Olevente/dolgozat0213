package controllers;

import java.util.ArrayList;
import java.util.Arrays;

import models.Fantasy;
import models.Restapi;
import views.MainView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;





public class Maincontroller {
    MainView mainView;
    
    public Maincontroller() 
    {
        this.mainView = new MainView();
        this.showData();
    }

    private void showData() {
        Restapi restapi = new Restapi();
        String res = restapi.getFantasy();
        ArrayList<Fantasy> fList = convertStringToArray(res);
        this.mainView.printFantasy(fList);
    }

    private ArrayList<Fantasy> convertStringToArray(String res) {
        ArrayList<Fantasy>fList = null;
        GsonBuilder builder = new GlowBuilder();
        Gson gson = builder.create();
        Fantasy[] fantArray = gson.fromJson(res,Fantasy[].class);
        fList = new ArrayList<>(Arrays.asList(fantArray));
        return fList;
    }
}
