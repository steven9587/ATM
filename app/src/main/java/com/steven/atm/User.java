package com.steven.atm;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private Context context;
    String id;
    String nickname;
    int age;
    int gender;
    SharedPreferences setting ;
    boolean valid = false;
    public User(Context context){
        this.context = context;
        setting = context.getSharedPreferences("user",Context.MODE_PRIVATE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        if (nickname == null) {
            nickname = setting.getString("USERNICKNAME", null);
        }
        return nickname;
    }

    public void setNickname(String nickname) {
        setting.edit()
                .putString("USERNICKNAME", nickname)
                .apply();
        this.nickname = nickname;
    }

    public int getAge() {
        if (age == 0) {
            age = setting.getInt("USERAGE", 0);
        }
        return age;
    }

    public void setAge(int age) {
        setting.edit()
                .putInt("USERAGE", age)
                .apply();
        this.age = age;
    }

    public int getGender() {
        if (gender == 0) {
            gender = setting.getInt("USERGENDER",0);
        }
        return gender;
    }

    public void setGender(int gender) {
        setting.edit()
                .putInt("USERGENDER",gender)
                .apply();
        this.gender = gender;
    }

    public boolean isValid() {
        valid = getNickname() !=null && getAge() !=0 && getGender() !=0;
        return valid;
    }
}
