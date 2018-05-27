package com.example.laz3r.emergencymedicalapp.model;



public class Feed {
    
    private String imgUrl;
    
    private String feedHeader;
    
    private String feedContent;
    
    
    
    
    public Feed(String imgUrl, String feedHeader, String feedContent) {
        this.imgUrl = imgUrl;
        this.feedHeader = feedHeader;
        this.feedContent = feedContent;
    }
    

    
    public String getImgUrl() {
        return this.imgUrl;
    }
    
    
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    
    
    public String getFeedHeader() {
        return this.feedHeader;
    }
    
    
    public void setFeedHeader(String feedHeader) {
        this.feedHeader = feedHeader;
    }
    
    
    
    public String getFeedContent() {
        return this.feedContent;
    }
    
    
    public void setFeedContent(String feedContent) {
        this.feedContent = feedContent;
    }
    
    
    
    
}
