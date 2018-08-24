package com.example.dbsample_01.database;

public class DBTables {

    public static final int TYPE_BATTERY_RESET = 1;
    public static final int TYPE_WELDINNG_TIME = 2;

    public static final String CREATE_TABLE_HEAD = "CREATE TABLE IF NOT EXISTS ";
    public static final String DROP_TABLE_HEAD = "DROP TABLE IF EXISTS ";
    public static final String INSERT_TABLE_HEAD = "INSERT INTO ";
    public static final String DELETE_TABLE_HEAD = "DELETE FROM ";

    public static final String SELECT_TABLE_HEAD = "SELECT * FROM ";

    public static final String BATTERY_RESET_TABLE_NAME = "battery_reset ";
    public static final String BATTERY_RESET_BODY = " ( " +
                    " _id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , " +
                    " reset_date    TEXT  	, " +
                    " reset_time    TEXT  	, " +
                    " reset_count   INTEGER , " +
                    " rcv_date      TEXT  	, " +
                    " rcv_time      TEXT  	, " +
                    " worker_id     TEXT  	, " +
                    " snd_date      TEXT  	, " +
                    " snd_time      TEXT  	, " +
                    " send     TEXT  	);";

    public static final String CREATE_SQL_BATTERY_RESET = CREATE_TABLE_HEAD + BATTERY_RESET_TABLE_NAME + BATTERY_RESET_BODY ;
    public static final String DROP_SQL_BATTERY_RESET = DROP_TABLE_HEAD + BATTERY_RESET_TABLE_NAME +";" ;
    public static final String SELECT_SQL_BATTERY_RESET = SELECT_TABLE_HEAD + BATTERY_RESET_TABLE_NAME +";" ;
    public static final String INSERT_SQL_BATTERY_RESET = INSERT_TABLE_HEAD + BATTERY_RESET_TABLE_NAME +" VALUES " ;
    public static final String DELETE_SQL_BATTERY_RESET = DELETE_TABLE_HEAD + BATTERY_RESET_TABLE_NAME +";" ;

    public static final String WELDING_TIME_TABLE_NAME = "welding_time ";
    public static final String WELDING_TIME_BODY = " ( " +
            " _id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , " +
            " welding_date    TEXT  	, " +
            " welding_time    TEXT  	, " +
            " welding_count   INTEGER , " +
            " rcv_date      TEXT  	, " +
            " rcv_time      TEXT  	, " +
            " worker_id     TEXT  	, " +
            " snd_date      TEXT  	, " +
            " snd_time      TEXT  	, " +
            " send     TEXT  	);";

    public static final String CREATE_SQL_WELDING_TIME = CREATE_TABLE_HEAD + WELDING_TIME_TABLE_NAME + WELDING_TIME_BODY ;
    public static final String DROP_SQL_WELDING_TIME = DROP_TABLE_HEAD + WELDING_TIME_TABLE_NAME +";" ;
    public static final String SELECT_SQL_WELDING_TIME = SELECT_TABLE_HEAD + WELDING_TIME_TABLE_NAME +";" ;
    public static final String INSERT_SQL_WELDING_TIME = INSERT_TABLE_HEAD + WELDING_TIME_TABLE_NAME +" VALUES " ;
    public static final String DELETE_SQL_WELDING_TIME = DELETE_TABLE_HEAD + WELDING_TIME_TABLE_NAME +";" ;
}
