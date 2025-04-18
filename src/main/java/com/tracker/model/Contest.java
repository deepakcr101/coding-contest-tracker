package com.tracker.model;

public class Contest {
    private String name;
    private String url;
    private String platform;
    private long startTime;
    //private String duration; // or long/int depending on your use


    public Contest() {}

    public Contest(String name, String url, String platform, long startTime) {
        this.name = name;
        this.url = url;
        this.platform = platform;
        this.startTime = startTime;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getPlatform() {
        return platform;
    }

    public long getStartTime() {
        return startTime;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
