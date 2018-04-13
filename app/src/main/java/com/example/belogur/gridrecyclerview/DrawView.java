package com.example.belogur.gridrecyclerview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();

    private void init() {
        paint.setColor(Color.RED);
    }

    public DrawView(Context context) {
        super(context);
        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
public void onDraw(Canvas canvas) {
        final int size = 20;
        canvas.drawLine(0, 0, size, size, paint);
        canvas.drawLine(size, 0, 0, size, paint);
    }

}
