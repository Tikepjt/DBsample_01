package com.example.dbsample_01.database.datatable;

public class WeldingTime extends BaseTable {

    public WeldingTime( int id, String welding_date, String welding_time, int welding_count,
                        String rcv_date, String rcv_time, String worker_id,
                        String snd_date, String snd_time, String send ){
        this.id = id;
        this.welding_date = welding_date;
        this.welding_time = welding_time;
        this.welding_count = welding_count;
        this.rcv_date = rcv_date;
        this.rcv_time = rcv_time;
        this.worker_id = worker_id;

        this.snd_date = snd_date;
        this.snd_time = snd_time;
        this.send = send;
    }

    private String welding_date;
    private String welding_time;
    private int welding_count;


    public String getWelding_date() {
        return welding_date;
    }

    public void setWelding_date(String welding_date) {
        this.welding_date = welding_date;
    }

    public String getWelding_time() {
        return welding_time;
    }

    public void setWelding_time(String welding_time) {
        this.welding_time = welding_time;
    }

    public int getWelding_count() {
        return welding_count;
    }

    public void setWelding_count(int welding_count) {
        this.welding_count = welding_count;
    }




}
