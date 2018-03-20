package com.chyss.chartdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author chyss
 */
public class ChartView extends View
{
    // 显示格数
    public static final int SHOWS = 60;
    // 细线大小
    public static final float LSCALE = 0.1f;
    //粗线大小
    public static final float WSCALE = 0.7f;
    // 背景颜色
    public static final String BACK_COLOR = "#F5F5F5";

    // chart的长度
    private int width;
    // chart的高度
    private int height;
    // K 线宽
    private float lineW;
    // 数据
    private ChartData datas;
    // 最大值
    private float bigest;
    // 最小值
    private float smallest;

    /**
     * K 线设置，数据更新
     *
     * @param datas
     */
    public void setData(ChartData datas)
    {
        this.datas = datas;
        bigest = datas.getBigest();
        smallest = datas.getSmallest();

        invalidate();
    }

    public ChartView(Context context)
    {
        super(context);
    }

    public ChartView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        // 绘制背景
//        Paint paint = new Paint();
//        paint.setColor(Color.parseColor(BACK_COLOR));
//        canvas.drawRect(0,0,width,height,paint);

        // 绘制日K 线
        drawDayChart(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {


        width = right - left;
        height = bottom - top;
        lineW = width/ (SHOWS + 2);

        Log.e("view","left : "+left+",top : "+top+",right : "+right+",bottom : "+bottom+",lineW : "+lineW);

        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        Log.e("view","widthMeasureSpec : "+widthMeasureSpec+",heightMeasureSpec : "+heightMeasureSpec);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 绘制日K 线
     *
     * @param canvas
     */
    private void drawDayChart(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#C7C7C7"));
        paint.setTextSize(30.0f);
        canvas.drawText(bigest+"",20,60,paint);
        canvas.drawText(smallest+"",20,height - 30,paint);

        Paint pl = new Paint();
        pl.setColor(Color.parseColor("#EEE5DE"));
        pl.setStrokeWidth(1.0f);
        canvas.drawLine(0,height/4,width,height/4,pl);
        canvas.drawLine(0,height/2,width,height/2,pl);
        canvas.drawLine(0,height*3/4,width,height*3/4,pl);

        // 绘制K 线
        Paint paintL = new Paint();
        paintL.setStrokeWidth(lineW * LSCALE);
        Paint paintW = new Paint();
        paintW.setStrokeWidth(lineW * WSCALE);
        float scale = height / (bigest - smallest);

        for (int i = 0; i < datas.getDayDatas().size(); i++)
        {
            DayData data = datas.getDayDatas().get(i);
            if(data.getCurent() > data.getOpen())
            {
                // 设置为红色
                paintL.setColor(Color.RED);
                paintW.setColor(Color.RED);
            }
            else
            {
                // 设置为绿色
                paintL.setColor(Color.GREEN);
                paintW.setColor(Color.GREEN);
            }

            //计算绘制细线
            float yl0 = (bigest - data.getSmall()) * scale;
            float yl1 = (bigest - data.getBig()) * scale;
            canvas.drawLine(lineW * (i + 1),yl0,lineW * (i + 1),yl1,paintL);
            //计算绘制粗线
            float yw0 = (bigest - data.getOpen()) * scale;
            float yw1 = (bigest - data.getCurent()) * scale;
            canvas.drawLine(lineW * (i + 1),yw0,lineW * (i + 1),yw1,paintW);
        }
    }
}
