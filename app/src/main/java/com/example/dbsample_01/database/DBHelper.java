package com.example.dbsample_01.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dbsample_01.database.datatable.BaseTable;
import com.example.dbsample_01.database.datatable.BatteryReset;
import com.example.dbsample_01.database.datatable.SendTime;
import com.example.dbsample_01.database.datatable.WeldingTime;

import java.util.ArrayList;

import co.kr.ulike.mask.database.datatable.BaseTable;
import co.kr.ulike.mask.database.datatable.BatteryReset;
import co.kr.ulike.mask.database.datatable.SendTime;
import co.kr.ulike.mask.database.datatable.WeldingTime;

public class DBHelper extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();
    private Context context;
    private static final int DB_VER = 1;
    private static String DB_NAME = "otos.db";


~

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropTable( db);
        createTable( db );
    }

    private void createTable( SQLiteDatabase db ){
        //db.execSQL( DBTables.CREATE_TABLE + DBTables.DEVICE_LIST_TABLE_NAME + DBTables.DEVICE_LIST_BODY + DBTables.END_TABLE );
        db.execSQL( DBTables.CREATE_SQL_BATTERY_RESET );
        db.execSQL( DBTables.CREATE_SQL_WELDING_TIME );
    }

    private void dropTable( SQLiteDatabase db  ) {
        db.execSQL( DBTables.DROP_SQL_BATTERY_RESET );
        db.execSQL( DBTables.DROP_SQL_WELDING_TIME );
    }

    public void createTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( DBTables.CREATE_SQL_BATTERY_RESET );
        db.execSQL( DBTables.CREATE_SQL_WELDING_TIME );
    }

    public void dropTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( DBTables.DROP_SQL_BATTERY_RESET );
        db.execSQL( DBTables.DROP_SQL_WELDING_TIME );
    }


    // bSend = false: 아직 전송하지 않은 데이터만 select
    // bSend = true : 전송 성공한 데이터만 select
    // bSend = null : 모든 데이터 select
    public ArrayList<BaseTable> getDataList( int type , Boolean bSend ){

        ArrayList<BaseTable> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        String sql;

        if( type == DBTables.TYPE_BATTERY_RESET ){
            sql = getSelectSql( type, bSend );

            Cursor cursor = db.rawQuery( sql, null  );
            cursor.moveToFirst();

            for( int i = 0 ; i < cursor.getCount() ; i++ ){
                //DeviceInfo deviceInfo = new DeviceInfo( cursor.);
                int id   = cursor.getInt( cursor.getColumnIndex( "_id") );
                String reset_date   = cursor.getString( cursor.getColumnIndex( "reset_date") );
                String reset_time   = cursor.getString( cursor.getColumnIndex( "reset_time") );
                int reset_count     = cursor.getInt( cursor.getColumnIndex( "reset_count") );

                String rcv_date     = cursor.getString( cursor.getColumnIndex( "rcv_date") );
                String rcv_time     = cursor.getString( cursor.getColumnIndex( "rcv_time") );
                String worker_id    = cursor.getString( cursor.getColumnIndex( "worker_id") );

                String snd_date     = cursor.getString( cursor.getColumnIndex( "snd_date") );
                String snd_time     = cursor.getString( cursor.getColumnIndex( "snd_time") );
                String send         = cursor.getString( cursor.getColumnIndex( "send") );

                BatteryReset item = new BatteryReset( id, reset_date, reset_time, reset_count, rcv_date, rcv_time, worker_id, snd_date, snd_time, send );
                dataList.add( item );
                cursor.moveToNext();
            }
            cursor.close();
        } else {
            sql = getSelectSql( type, bSend );

            Cursor cursor = db.rawQuery( sql, null  );
            cursor.moveToFirst();

            for( int i = 0 ; i < cursor.getCount() ; i++ ){
                //DeviceInfo deviceInfo = new DeviceInfo( cursor.);
                int id   = cursor.getInt( cursor.getColumnIndex( "_id") );
                String welding_date   = cursor.getString( cursor.getColumnIndex( "welding_date") );
                String welding_time   = cursor.getString( cursor.getColumnIndex( "welding_time") );
                int welding_count     = cursor.getInt( cursor.getColumnIndex( "welding_count") );

                String rcv_date     = cursor.getString( cursor.getColumnIndex( "rcv_date") );
                String rcv_time     = cursor.getString( cursor.getColumnIndex( "rcv_time") );
                String worker_id    = cursor.getString( cursor.getColumnIndex( "worker_id") );

                String snd_date     = cursor.getString( cursor.getColumnIndex( "snd_date") );
                String snd_time     = cursor.getString( cursor.getColumnIndex( "snd_time") );
                String send         = cursor.getString( cursor.getColumnIndex( "send") );

                WeldingTime item = new WeldingTime( id, welding_date, welding_time, welding_count, rcv_date, rcv_time, worker_id, snd_date, snd_time, send );
                dataList.add( item );
                cursor.moveToNext();
            }
            cursor.close();
        }
        return dataList;
    }

    private String getSelectSql( int type , Boolean bSend ){

        String sql;

        if( type == DBTables.TYPE_BATTERY_RESET ) {
            sql = DBTables.SELECT_SQL_BATTERY_RESET;
        } else {
            sql = DBTables.SELECT_SQL_WELDING_TIME;
        }

        // bSend = false: 아직 전송하지 않은 데이터만 select
        // bSend = true : 전송 성공한 데이터만 select
        // bSend = null : 모든 데이터 select
        if( bSend == null){
        } else if( bSend ){
            sql = sql.replaceAll(";", "");
            sql += " where send ='true'; ";
        } else {
            sql = sql.replaceAll(";", "");
            sql += " where send !='true'; ";
        }

        return sql;
    }

    public void insertList( int type, ArrayList<BaseTable> dataList ){

        SQLiteDatabase db = this.getWritableDatabase();

        if( dataList.size() < 0 ){
            return;
        }

        if( dataList.size() == 1){

            BatteryReset tmpData = (BatteryReset) dataList.get( 0 );

            String sql = DBTables.INSERT_SQL_BATTERY_RESET + " ( null, '"
                    + tmpData.getReset_date() + "', '"
                    + tmpData.getReset_time() + "', "
                    + tmpData.getReset_count() + ", '"
                    + tmpData.getRcv_date() + "', '"
                    + tmpData.getRcv_time() + "', '"
                    + tmpData.getWorker_id() + "', '"
                    + tmpData.getSnd_date() + "', '"
                    + tmpData.getSnd_time() + "', '"
                    + tmpData.getSend() + ( "');");

            db.execSQL( sql );
        } else {
            String sql = sql = DBTables.INSERT_SQL_BATTERY_RESET ;
            for( int i = 0 ; i < dataList.size() ; i++ ){
                BatteryReset tmpData = (BatteryReset) dataList.get( i );


                sql +=  " ( null, '"
                        + tmpData.getReset_date() + "', '"
                        + tmpData.getReset_time() + "', "
                        + tmpData.getReset_count() + ", '"
                        + tmpData.getRcv_date() + "', '"
                        + tmpData.getRcv_time() + "', '"
                        + tmpData.getWorker_id() + "', '"
                        + tmpData.getSnd_date() + "', '"
                        + tmpData.getSnd_time() + "', '"
                        + tmpData.getSend() + ( "') ");

                if( i != dataList.size() - 1) {
                    sql += ", ";
                }
            }
            db.execSQL( sql );
        }

    }


    public void updateList(int type, ArrayList<SendTime> stList ){
        //update


    }

    public void deleteList(){
        //update
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL( DBTables.DELETE_SQL_BATTERY_RESET );
        db.execSQL( DBTables.DELETE_SQL_WELDING_TIME );


    }

}