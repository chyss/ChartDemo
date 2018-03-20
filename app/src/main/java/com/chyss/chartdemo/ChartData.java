package com.chyss.chartdemo;

import java.util.List;

/**
 * @author chyss
 */

public class ChartData
{
    private float smallest;
    private float bigest;
    private List<DayData> dayDatas;

    public List<DayData> getDayDatas()
    {
        return dayDatas;
    }

    public void setDayDatas(List<DayData> dayDatas)
    {
        this.dayDatas = dayDatas;
    }

    public float getSmallest()
    {
        return smallest;
    }

    public void setSmallest(float smallest)
    {
        this.smallest = smallest;
    }

    public float getBigest()
    {
        return bigest;
    }

    public void setBigest(float bigest)
    {
        this.bigest = bigest;
    }
}
