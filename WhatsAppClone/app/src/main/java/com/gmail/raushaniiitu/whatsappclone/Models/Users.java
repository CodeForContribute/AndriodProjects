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

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        UserEmailAddress = userEmailAddress;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public void setLastMsgId(String lastMsgId) {
        this.lastMsgId = lastMsgId;
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

    public void getUserId(String key) {
    }
}
