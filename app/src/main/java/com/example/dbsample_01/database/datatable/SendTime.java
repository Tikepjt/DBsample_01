package com.example.dbsample_01.database.datatable;

public class SendTime {

    public SendTime( int id, String snd_date, String snd_time, String send ){
        this.id = id;
        this.snd_date = snd_date;
        this.snd_time = snd_time;
        this.send = send;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String snd_date;
    private String snd_time;
    private String send;


    public String getSnd_date() {
        return snd_date;
    }

    public void setSnd_date(String snd_date) {
        this.snd_date = snd_date;
    }

    public String getSnd_time() {
        return snd_time;
    }

    public void setSnd_time(String snd_time) {
        this.snd_time = snd_time;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }



}
