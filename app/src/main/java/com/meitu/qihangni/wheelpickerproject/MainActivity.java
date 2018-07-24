package com.meitu.qihangni.wheelpickerproject;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.meitu.qihangni.wheelpickerproject.timewheelpicker.TimePickerManager;


/**
 *
 */
public class MainActivity extends Activity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.btn_timepicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerManager.buid(mContext);
            }
        });

    }
}
