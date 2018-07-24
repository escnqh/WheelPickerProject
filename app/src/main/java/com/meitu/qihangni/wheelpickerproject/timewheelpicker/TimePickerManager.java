package com.meitu.qihangni.wheelpickerproject.timewheelpicker;

import android.content.Context;
import android.view.View;


import com.meitu.qihangni.wheelpickerproject.timewheelpicker.pickerview.builder.OptionsPickerBuilder;
import com.meitu.qihangni.wheelpickerproject.timewheelpicker.pickerview.listener.OnOptionsSelectChangeListener;
import com.meitu.qihangni.wheelpickerproject.timewheelpicker.pickerview.listener.OnOptionsSelectListener;
import com.meitu.qihangni.wheelpickerproject.timewheelpicker.pickerview.view.OptionsPickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author nqh 2018/7/23
 */
public class TimePickerManager {
    private static List<String> mDatelist = new ArrayList<>();
    private static List<String> mHourlist = new ArrayList<>();
    private static List<String> mMinutelist = new ArrayList<>();
    private static int mHourPosition = 0;
    private static int mMinutePosition = 0;
    private static Date mDate;
    private static long time = System.currentTimeMillis();
    private static OptionsPickerView mTimePickerView;

    public static void buid(Context context) {
        setDatelist();
        setHourlist();
        setMinutelist();
        mTimePickerView = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

            }
        }).setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
            @Override
            public void onOptionsSelectChanged(int options1, int options2, int options3) {

            }
        }).build();
        mTimePickerView.setTitleText("视频上传后，将会在该时间自动发布。");
        mTimePickerView.setNPicker(mDatelist, mHourlist, mMinutelist);
        mTimePickerView.setSelectOptions(0, mHourPosition, mMinutePosition);
        mTimePickerView.show();
    }

    /**
     * 设置日期list（默认开始位置为今日）
     */
    private static void setDatelist() {
        mDatelist.clear();
        mDatelist.add("今日");
        for (int i = 1; i < 7; i++) {
            mDate = new Date(time + i * 86400000);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M月d日 E");
            mDatelist.add(simpleDateFormat.format(mDate).toString());
        }
    }

    /**
     * 设置小时list，确定初始位置
     */
    private static void setHourlist() {
        mHourlist.clear();
        mHourPosition = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                mHourlist.add("0" + i);
            } else {
                mHourlist.add("" + i);
            }
        }
    }

    /**
     * 设置分钟list，确定初始位置
     */
    private static void setMinutelist() {
        mMinutelist.clear();
        int minute = Calendar.getInstance().get(Calendar.MINUTE);
        mMinutePosition = minute / 5 + 1;
        if (mMinutePosition == 12) {
            mMinutePosition = 0;
            mHourPosition += 1;
        }
        for (int i = 0; i < 60; i += 5) {
            if (i < 10) {
                mMinutelist.add("0" + i);
            } else {
                mMinutelist.add("" + i);
            }
        }
    }

}
