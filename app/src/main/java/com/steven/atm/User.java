package com.steven.atm;

public class User {
    String id;
    String nickname;
    int age;

    public String getUserid() {
        return id;
    }

    public void setUserid(String userid) {
        this.id = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    int gender;

}
