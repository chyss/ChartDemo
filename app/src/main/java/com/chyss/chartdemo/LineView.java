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
public class LineView extends View
{

    // chart的长度
    private int width;
    // chart的高度
    private int height;

    /**
     * K 线设置，数据更新
     *
     * @param datas
     */
    public void setData(ChartData datas)
    {
        invalidate();
    }

    public LineView(Context context)
    {
        super(context);
    }

    public LineView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr)
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

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        width = right - left;
        height = bottom - top;
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        Log.e("view","widthMeasureSpec : "+widthMeasureSpec+",heightMeasureSpec : "+heightMeasureSpec);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
