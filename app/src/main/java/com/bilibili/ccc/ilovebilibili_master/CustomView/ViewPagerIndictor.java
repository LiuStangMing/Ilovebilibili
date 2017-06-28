package com.bilibili.ccc.ilovebilibili_master.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ViewPagerIndictor extends LinearLayout {

    private Paint mPaint;
    //TAB的宽度
    private int mTabWidth;
    //初始的偏移量
    private int mInitTransltionX;
    //偏移量
    private int mTransltionX;
    //线的长度
    private int mLineWidth;

    public ViewPagerIndictor(Context context) {
        this(context,null);
    }

    public ViewPagerIndictor(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ViewPagerIndictor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.WHITE);

    }

    public void setItemTitles(String[] titles){
        if(titles != null && titles.length > 0){
            this.removeAllViews();
            for (String title : titles){
                TextView textView = new TextView(getContext());
                LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT);
                lp.width = getScreenWidth() / 5;
                textView.setText(title);
                if (title.equals("直播")){
                    textView.setTextColor(Color.WHITE);
                }else{
                    textView.setTextColor(Color.parseColor("#e6e6e6"));
                }
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
                textView.setGravity(Gravity.CENTER);
                textView.setLayoutParams(lp);
                this.addView(textView);
            }
        }
        setTitleClick();
    }

    private void setTitleClick() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount ; i++){
            final int j = i;
            View view = getChildAt(i);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem(j);
                }
            });
        }
    }


    /**
     * 获取屏幕的宽度
     * @return
     */
    private int getScreenWidth(){
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mTabWidth = w / 5;
        mInitTransltionX = mTabWidth / 6;
        mLineWidth = mTabWidth * 2 / 3;

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        canvas.translate(mInitTransltionX + mTransltionX ,getHeight() - 3);
        canvas.drawLine(0,0,mLineWidth,0,mPaint);
        canvas.restore();
    }

    public void scroll(int position,float positionOffset){
        //滑动到最后一个时
        //tabwidth * position + tabwidth * position
        mTransltionX = (int) (mTabWidth * (positionOffset + position));
        if(position > 3 && positionOffset > 0){
            this.scrollTo((position + 1) * mTabWidth , 0);
        }
        invalidate();
    }

    private ViewPager mViewPager;

    public void setViewPager(ViewPager viewpager,int position){
        mViewPager = viewpager;
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                scroll(position,positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
                titleColorReset();
                TextView tv = (TextView) getChildAt(position);
                tv.setTextColor(Color.WHITE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setCurrentItem(position);
    }

    /**
     * title字体颜色重置
     */
    private void titleColorReset(){
        int childCount = getChildCount();
        for (int i = 0 ; i < childCount ; i++){
            TextView tv = (TextView) getChildAt(i);
            tv.setTextColor(Color.parseColor("#e6e6e6"));
        }
    }

}
