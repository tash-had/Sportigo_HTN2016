package me.app.sportigov4;

public class UserData {
    private String fname;
    private String lname;
    private String bio;
    private String phone;
    private String eventIds;

    public UserData() {

    }

    public UserData(String fname, String lname, String bio, String phone, String eventIds) {
        this.fname = fname;
        this.lname = lname;
        this.bio = bio;
        this.phone = phone;
        this.eventIds = eventIds;

    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getBio() {
        return bio;
    }

    public String getPhone() {
        return phone;
    }

    public String getEventIds() {
        return eventIds;
    }
}

