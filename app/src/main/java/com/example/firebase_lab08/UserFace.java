package com.example.firebase_lab08;

public class UserFace {
    private String key;
    private String userName;
    private String userMail;
    private String userPass;
    private int happy;
    private int noHappy;
    private int normal;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getNoHappy() {
        return noHappy;
    }

    public void setNoHappy(int noHappy) {
        this.noHappy = noHappy;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public UserFace() {

    }

    public UserFace(String userName, String userMail, String userPass, int happy, int noHappy, int normal) {
        this.userName = userName;
        this.userMail = userMail;
        this.userPass = userPass;
        this.happy = happy;
        this.noHappy = noHappy;
        this.normal = normal;
    }
}
