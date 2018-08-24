package com.example.dbsample_01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends Activity{

    public static String TAG;

    public Activity mAct;
    public Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        TAG = this.getClass().getSimpleName();
        mAct = this;
        mCtx = this;
    }

    public void ShowToast( String msg ){
        Toast.makeText( mCtx, msg, Toast.LENGTH_SHORT).show();
    }



}
