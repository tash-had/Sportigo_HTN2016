package me.app.sportigov4;

public class EventsData {
    private long eventId;

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public void set_long(double _long) {
        this._long = _long;
    }

    public void set_lat(double _lat) {
        this._lat = _lat;
    }

    public void setSignedup(boolean signedup) {
        this.signedup = signedup;
    }

    public void setTotalNeeded(int totalNeeded) {
        this.totalNeeded = totalNeeded;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    private String eventName;
    private double _long;
    private double _lat;
    private boolean signedup;
    private int totalNeeded;
    private String desc;
    private String poster;
    private String participants;
    private String eventTime;

    public long getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public double get_long() {
        return _long;
    }

    public double get_lat() {
        return _lat;
    }

    public boolean isSignedup() {
        return signedup;
    }

    public int getTotalNeeded() {
        return totalNeeded;
    }

    public String getDesc() {
        return desc;
    }

    public String getPoster() {
        return poster;
    }

    public String getParticipants() {
        return participants;
    }

    public String getEventTime() {
        return eventTime;
    }

    public EventsData(){

    }
    public EventsData(long eventId, String eventName,double _long, double _lat, boolean signedup, int totalNeeded, String desc, String poster, String participants, String eventTime ){
        this.eventId = eventId;
        this.eventName = eventName;
        this._long = _long;
        this._lat = _lat;
        this.signedup = signedup;
        this.totalNeeded = totalNeeded;
        this.desc = desc;
        this.poster = poster;
        this.participants = participants;
        this.eventTime = eventTime;
    }
}
