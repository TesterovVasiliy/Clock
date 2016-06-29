package com.example.vserp.clock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Date;

/**
 * Created by vserp on 6/29/2016.
 */

public class ClockView extends View {

    Date date;
    int width;
    Paint paint;

    public ClockView(Context context, Date date) {
        super(context);
        this.date = date;
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(width/2,width/2,width/2,paint);

        paint.setColor(getResources().getColor(R.color.colorAccent));

        float sec=(float)date.getSeconds();
        float min=(float)date.getMinutes();
        float hour=(float)date.getHours()+min/60.0f;

        paint.setColor(0xFFFF0000);
        paint.setStrokeWidth(3);
        canvas.drawLine(width/2, width/2, (float)(width/2+(width/2-50)*Math.cos(Math.toRadians((hour / 12.0f * 360.0f)-90f))), (float)(width/2+(width/2-10)*Math.sin(Math.toRadians((hour / 12.0f * 360.0f)-90f))), paint);
        canvas.save();

        paint.setColor(0xFF0000FF);

        canvas.drawLine(width/2, width/2, (float)(width/2+(width/2-25)*Math.cos(Math.toRadians((min / 60.0f * 360.0f)-90f))), (float)(width/2+width/2*Math.sin(Math.toRadians((min / 60.0f * 360.0f)-90f))), paint);
        canvas.save();

        paint.setColor(0xFFA2BC13);
        canvas.drawLine(width/2, width/2, (float)(width/2+(width/2+10)*Math.cos(Math.toRadians((sec / 60.0f * 360.0f)-90f))), (float)(width/2+(width/2+15)*Math.sin(Math.toRadians((sec / 60.0f * 360.0f)-90f))), paint);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getMeasuredWidth() / 3;

        setMeasuredDimension(width,width);

        paint = new Paint();
        paint.setColor(Color.CYAN);
        setBackgroundColor(Color.GRAY);
    }
}
