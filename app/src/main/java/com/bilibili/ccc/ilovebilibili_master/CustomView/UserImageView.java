package com.bilibili.ccc.ilovebilibili_master.CustomView;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * 设置ImageView为圆形
 */
public class UserImageView extends ImageView {

    private Paint mPaint;

    public UserImageView(Context context) {
        this(context,null);
    }

    public UserImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public UserImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if(null != drawable){
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            //核心代码
            Bitmap b = getCircleBitmap(bitmap);
            mPaint.reset();
            canvas.drawBitmap(b,0,0,mPaint);
        }else{
            super.onDraw(canvas);
        }
    }

    private Bitmap getCircleBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        mPaint.setAntiAlias(true);
        Rect rect = new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
        //画圆，为下层图片
        canvas.drawCircle(bitmap.getWidth() / 2,bitmap.getHeight() / 2,
                bitmap.getHeight() / 2 , mPaint);
        //获取交集，显示上层图片，即为下面的bitmap
        /**
         * setXfermode()过渡模式
         */
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap,rect,rect,mPaint);
        return output;
    }
}
