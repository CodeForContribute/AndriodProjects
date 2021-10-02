package com.gmail.raushaniiitu.whatsappclone.Models;

public class Users {
    String profilePicture;
    String UserName;
    String UserEmailAddress;
    String UserPassword;
    String UserId;
    String lastMsgId;

    public Users(){
        //signUp Constructor
    }

    public Users(String profilePicture, String userName, String userEmailAddress, String userPassword, String userId, String lastMsgId) {
        this.profilePicture = profilePicture;
        UserName = userName;
        UserEmailAddress = userEmailAddress;
        UserPassword = userPassword;
        UserId = userId;
        this.lastMsgId = lastMsgId;
    }

    public Users(String userName, String userEmailAddress, String userPassword) {
        UserName = userName;
        UserEmailAddress = userEmailAddress;
        UserPassword = userPassword;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserEmailAddress() {
        return UserEmailAddress;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public String getUserId() {
        return UserId;
    }

    public String getLastMsgId() {
        return lastMsgId;
    }
}
