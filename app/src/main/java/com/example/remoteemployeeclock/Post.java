package com.example.remoteemployeeclock;

import com.parse.ParseClassName;
import com.parse.ParseObject;


@ParseClassName("Message")
public class Post extends ParseObject {
    public static final String KEY_NAME = "name";
    public static final String KEY_MESSAGE = "message";
    public static  final String KEY_USER = "user";
    public static final String KEY_DATE = "date" ;

    public String getName(){

        return getString(KEY_NAME);
    }
    public void setName(String name){
        put(KEY_NAME, name);
    }
    public String getMessage(){
        return getString(KEY_MESSAGE);
    }
    public void setMessage(String message){
        put(KEY_MESSAGE, message);
    }
    public String getUser(){
        return getString(KEY_USER);
    }
    public void setUser(String user){
        put(KEY_USER, user);
    }
    public String getDate(){
        return getString(KEY_DATE);
    }
    public void setDate(String date){
        put(KEY_DATE, date);
    }
}
