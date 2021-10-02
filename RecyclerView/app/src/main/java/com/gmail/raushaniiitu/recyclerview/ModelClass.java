package com.gmail.raushaniiitu.recyclerview;

public class ModelClass {
    private final int imageView;
    private final String UserNameTextView;
    private final String UserTimeTextView;
    private final String UserMsgTextView;

    public ModelClass(int imageView, String userNameTextView,String userMsgTextView, String userTimeTextView) {
        this.imageView = imageView;
        UserNameTextView = userNameTextView;
        UserTimeTextView = userTimeTextView;
        UserMsgTextView = userMsgTextView;
    }

    public int getImageView() {
        return imageView;
    }

    public String getUserNameTextView() {
        return UserNameTextView;
    }

    public String getUserTimeTextView() {
        return UserTimeTextView;
    }

    public String getUserMsgTextView() {
        return UserMsgTextView;
    }

}
