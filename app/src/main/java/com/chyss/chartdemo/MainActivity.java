package com.chyss.chartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ChartView main_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_chart = (ChartView)findViewById(R.id.main_chart);

        initData();
    }

    private void initData()
    {
        ChartData chartData = new ChartData();
        chartData.setBigest(13.05f);
        chartData.setSmallest(10.88f);

        List<DayData> dayDatas = new ArrayList<>();
        dayDatas.add(setData(12.08f,12.15f,11.85f,12.25f));
        dayDatas.add(setData(11.08f,11.15f,11.05f,12.05f));
        dayDatas.add(setData(12.08f,12.15f,11.85f,12.25f));
        dayDatas.add(setData(11.28f,11.05f,11.05f,12.05f));
        dayDatas.add(setData(11.28f,11.05f,11.02f,11.35f));
        dayDatas.add(setData(12.08f,12.15f,11.85f,12.25f));
        chartData.setDayDatas(dayDatas);

        main_chart.setData(chartData);
    }

    private DayData setData(float open,float curent,float small,float big)
    {
        DayData data = new DayData();
        data.setOpen(open);
        data.setCurent(curent);
        data.setBig(big);
        data.setSmall(small);
        return data;
    }
}
