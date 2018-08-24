package com.example.dbsample_01.database.datatable;

public class BaseTable {

    public String getRcv_date() {
        return rcv_date;
    }

    public void setRcv_date(String rcv_date) {
        this.rcv_date = rcv_date;
    }

    public String getRcv_time() {
        return rcv_time;
    }

    public void setRcv_time(String rcv_time) {
        this.rcv_time = rcv_time;
    }

    public String getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(String worker_id) {
        this.worker_id = worker_id;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;
    public String rcv_date;
    public String rcv_time;
    public String worker_id;
    public String snd_date;
    public String snd_time;
    public String send;
}
