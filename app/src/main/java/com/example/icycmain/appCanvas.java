package com.example.icycmain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class appCanvas extends View {

    Paint paint;
    Path path;
    Canvas canvas;


    public appCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPosition = event.getX();
        float yPosition = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :
                path.moveTo(xPosition, yPosition);
                return true;

            case MotionEvent.ACTION_MOVE :
                path.lineTo(xPosition, yPosition);
                break;

            case MotionEvent.ACTION_UP:
                break;

            default:
                return false;



        }
        invalidate();
        return true;

    }

    public void clear(){


    }
}