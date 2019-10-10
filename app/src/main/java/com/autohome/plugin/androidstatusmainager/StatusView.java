package com.autohome.plugin.androidstatusmainager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 根据状态的不同显示不同的内容
 *
 * 画一个矩形，每一种状态代表一种颜色值，
 * 组合颜色和单一颜色值进行绘制
 */
public class StatusView extends View {

    public static final int STATUS_0 = 0x1; // 1
    public static final int STATUS_1 = 0x1 << 1; // 10
    public static final int STATUS_2 = 0x1 << 2; // 100
    public static final int STATUS_3 = 0x1 << 3; // 1000
    public static final int STATUS_4 = 0x1 << 4; // 10000
    public static final int STATUS_5 = 0x1 << 5; // 100000
    public static final int STATUS_6 = 0x1 << 6; // 1000000
    public static final int STATUS_7 = 0x1 << 7; // 10000000
    public static final int STATUS_8 = 0x1 << 8; // 100000000
    public static final int STATUS_9 = 0x1 << 9; // 1000000000

    private static final int[] COLORS = {
            Color.BLACK,
            Color.DKGRAY,
            Color.GRAY,
            Color.LTGRAY,
            Color.WHITE,
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA
    };

    private static final int[] STATUSS = {
            STATUS_0,
            STATUS_1,
            STATUS_2,
            STATUS_3,
            STATUS_4,
            STATUS_5,
            STATUS_6,
            STATUS_7,
            STATUS_8,
            STATUS_9
    };

    private int status = STATUS_0;

    private Paint mPaint;

    private int mViewWidth;
    private int mViewHeight;

    public StatusView(Context context) {
        super(context);
        init();
    }

    public StatusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        setPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int w;
        int h;
        if (widthMode == MeasureSpec.EXACTLY) {
            w = width;
        } else {
            w = 100; // wrap_content宽度
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            h = height;
        } else {
            h = 100; // wrap_content高度
        }
        setMeasuredDimension(w, h);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawRec(canvas);
    }

    private void drawRec(Canvas canvas) {
        for (int i = 0; i < STATUSS.length; i++) {
            if (isContains(STATUSS[i])) {
                mPaint.reset();
                setPaint();
                mPaint.setColor(COLORS[i]);
                int offset = i * 20;
                canvas.drawRect(offset, offset, mViewWidth - offset, mViewHeight - offset, mPaint);
            }
        }
    }

    private void setPaint() {
        mPaint.setTextSize(20);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void updateState(int state) {
        this.status = state;
        invalidate();
    }

    public void addStatus(int state) {
        if (!isContains(state)) {
            addState(state);
            invalidate();
        }
    }

    public void deleteStatus(int state) {
        if (isContains(state)) {
            deleteState(state);
            invalidate();
        }
    }

    /**
     * 添加状态
     */
    private void addState(int a) {
        status = status | a;
    }

    /**
     * 移除状态
     */
    private void deleteState(int a) {
        status = status & ~ a;
    }

    /**
     * 判断当前状态是否包含
     */
    private boolean isContains(int a) {
        return (status & a) != 0;
    }

    /**
     * 判断二进制位后面有几位
     */
    private int getIndex(int a) {
        if (a <= 0) {
            return 0;
        }
        int index = 0;
        if (a == 1) {
            return 0;
        }
        do {
            a = a >> 1;
            index ++;
        } while (a != 1);
        return index;
    }
}
