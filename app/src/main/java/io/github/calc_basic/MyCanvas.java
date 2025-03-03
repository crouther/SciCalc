package io.github.calc_basic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyCanvas extends View
{
    Paint paint;
    Path path;
    public MyCanvas (Context context, AttributeSet as){
        super(context, as);
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }
    @Override
    protected void onDraw (Canvas c){
        super.onDraw(c);
        c.drawPath(path,paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float xPos = event.getX();
        float yPos = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos,yPos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos,yPos);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;

        }
        invalidate();
        return true;
    }

    public void clear(Canvas c, int width, int height) {
        Bitmap mBitmap = Bitmap.createBitmap(width,height ,
                Bitmap.Config.ARGB_8888);

        Canvas mCanvas = new Canvas(mBitmap);
        Path mPath = new Path();
        Paint mBitmapPaint = new Paint(Paint.DITHER_FLAG);

        //Added later..
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);
        invalidate();
    }


}
