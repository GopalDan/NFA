package com.example.gopal.nfa;

/**
 * Created by Gopal on 10/28/2018.
 */

public class Event {
    private String mWebTitle;
    private String mThumbnailResourceId;
    public Event(String webTitle, String thumbnailResourceId){
        mWebTitle = webTitle;
        mThumbnailResourceId = thumbnailResourceId;
    }

    public String getmWebTitle() {
        return mWebTitle;
    }

    public String getmThumbnailResourceId() {
        return mThumbnailResourceId;
    }

}
