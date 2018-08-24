package com.example.dbsample_01;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dbsample_01.database.DBHelper;
import com.example.dbsample_01.database.DBTables;
import com.example.dbsample_01.database.datatable.BaseTable;
import com.example.dbsample_01.database.datatable.BatteryReset;
import com.example.dbsample_01.util.Util;

import java.util.ArrayList;

public class TempActivity extends BaseActivity {

    private DBHelper mSQL;
    private Cursor cursor;

    Button mBtnSelect, mBtnUpdate, mBtnInsert, mBtnCreate, mBtnDrop, mBtnDelete;
    TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView(R.layout.activity_temp) ;

        mSQL = new DBHelper(this);

        initViews() ;
    }

    private void initViews(){
        mBtnSelect = findViewById(R.id.btnSelect);
        mBtnUpdate = findViewById(R.id.btnUpdate);
        mBtnInsert = findViewById(R.id.btnInsert);
        mBtnCreate = findViewById(R.id.btnCreate);
        mBtnDrop = findViewById(R.id.btnDrop);
        mBtnDelete = findViewById(R.id.btnDelete );


        mTvResult = findViewById(R.id.tvResult);

        mBtnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast("조회");
                ArrayList<BaseTable> dataList = mSQL.getDataList(DBTables.TYPE_BATTERY_RESET, null );
                updateView( dataList );
            }
        });

        mBtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast("추가");
                ArrayList<BaseTable>  dataList = new ArrayList<>();

                BatteryReset tmpData = new BatteryReset( 0,
                        Util.getToday(),
                        Util.getNowTime(),
                        ((int) (Math.random() *10) +1),
                        Util.getToday(),
                        Util.getNowTime(),
                        "GS",
                        "", "", "");

                dataList.add( tmpData );

                mSQL.insertList( DBTables.TYPE_BATTERY_RESET, dataList );
            }
        });



        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast("수정");
            }
        });

        mBtnDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSQL.dropTable();
            }
        });

        mBtnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSQL.createTable();
            }
        });

        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSQL.deleteList();
            }
        });
    }

    private void updateView( ArrayList<BaseTable> dataList ){

        if( dataList.size() ==0  ){
            mTvResult.setText( "데이터 0건입니다.");
            return;
        }

        String result = "";
        for( int i = 0 ; i < dataList.size() ; i++ ){
            BatteryReset tmpData = (BatteryReset) dataList.get( i );
            result += tmpData.getId() + ", "
                    + tmpData.getReset_date() + ", "
                    + tmpData.getReset_time() + ", "
                    + tmpData.getReset_count() + ", "
                    + tmpData.getWorker_id()  + "\r\n";
        }

        mTvResult.setText( result );
    }
}
