package com.example.dbsample_01.database.datatable;

public class BatteryReset extends BaseTable{

    public BatteryReset( int id, String reset_date, String reset_time, int reset_count,
                         String rcv_date, String rcv_time, String worker_id,
                         String snd_date, String snd_time, String send ){

        this.id = id;
        this.reset_date = reset_date;
        this.reset_time = reset_time;
        this.reset_count = reset_count;
        this.rcv_date = rcv_date;
        this.rcv_time = rcv_time;
        this.worker_id = worker_id;

        this.snd_date = snd_date;
        this.snd_time = snd_time;
        this.send = send;
    }

    private String reset_date;
    private String reset_time;
    private int reset_count;


    public String getReset_date() {
        return reset_date;
    }

    public void setReset_date(String reset_date) {
        this.reset_date = reset_date;
    }

    public String getReset_time() {
        return reset_time;
    }

    public void setReset_time(String reset_time) {
        this.reset_time = reset_time;
    }

    public int getReset_count() {
        return reset_count;
    }

    public void setReset_count(int reset_count) {
        this.reset_count = reset_count;
    }


}
