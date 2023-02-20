package models;
public class Restapi {
    public Restapi(){

    }
    public String getOlev(){
        HttpClient http = new HttpClient();
        String host = "http://[::1]:3000/";
        String endpoint = "Olev";
        String urlStr = host + endpoint;
        String res = http.get(urlStr);
        return res;
    }
}
