package com.example.shc.respository;

import android.content.SharedPreferences;

public class UserLocalRepository implements LocalRepository {

    private String username;
    private String password;
    private String objectId;
    private String sessionToken;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public UserLocalRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
        updateFromLocal();
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    private void updateFromLocal(){
        username = sharedPreferences.getString("username","");
        password = sharedPreferences.getString("password","");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        editor.putString("username",username);
        editor.commit();
    }

    public String getPassword() {
        return password;
    }

    public void update(String username,String password){
        this.password = password;
        editor.putString("password",password);
        this.username = username;
        editor.putString("username",username);
        editor.commit();
    }

    public void setPassword(String password) {
        this.password = password;
        editor.putString("password",password);
        editor.commit();
    }
}
