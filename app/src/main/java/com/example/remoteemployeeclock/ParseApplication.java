package com.example.remoteemployeeclock;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("VSOYnjXdLKnFHah3AvGvKjjJ5vXkDqVV00zjSczn")
                .clientKey("M85BP8kCnV9xAKqyE23QqxXxzZnNNSl2gLH6QWfe")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
