package com.floatlayout1.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MyScrollView.OnScrollViewListener {

    private MyScrollView mMyScrollView;
    private MyScrollView.OnScrollViewListener mOnScrollViewListener;
    //跟随scrollview滚动的布局
    private View mFloatLayout;
    /*固定的布局*/
    private View mTopLayout;
    /*购买按钮*/
    private Button mBuyBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyScrollView= (MyScrollView) findViewById(R.id.myscrollview);
        mMyScrollView.setOnScrollViewListener(this);
        mFloatLayout=findViewById(R.id.opt_layout);
        mTopLayout=findViewById(R.id.top_opt_layout);
        mBuyBtn= (Button) mTopLayout.findViewById(R.id.buy_btn);

        /*添加全局滚动监听*/
        mMyScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                setOnscrollViewListener(mMyScrollView, mMyScrollView.getScrollX(), mMyScrollView.getScrollY(), 0, 0);

            }
        });
        /*购买按钮事件*/
        mBuyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("tag", "onClick: " );
            }
        });
    }

    @Override
    public void setOnscrollViewListener(MyScrollView myScrollView, int x, int y, int oldX, int oldY) {
        int mLayout2ParentTop=Math.max(y,mFloatLayout.getTop());
        mTopLayout.layout(0,mLayout2ParentTop,mTopLayout.getWidth(),mLayout2ParentTop+mTopLayout.getHeight());
    }
}
