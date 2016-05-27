package com.floatlayout1.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by GXCheng on 2016/5/27 9:20
 */
public class MyScrollView extends ScrollView {

    private OnScrollViewListener onScrollViewListener;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollViewListener!=null){
            onScrollViewListener.setOnscrollViewListener(this,l,t,oldl,oldt);
        }
    }

    public interface OnScrollViewListener{
        void setOnscrollViewListener(MyScrollView myScrollView,int x,int y,int oldX,int oldY);
    }

    public void setOnScrollViewListener(OnScrollViewListener onScrollViewListener){
        this.onScrollViewListener=onScrollViewListener;
    }
}
