package test.view.zhangtao.viewscrollbackdemo1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by zhangtao on 16/12/6.
 */

public class ScrollBackLayout extends LinearLayout
{
    private int mMove;
    private int yDown , yMove;
    private int i = 0;
    private boolean isIntercept;
    private MyScrollView scrollView;

    public ScrollBackLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        super.onLayout(changed, l, t, r, b);
        scrollView = (MyScrollView) getChildAt(0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int y = (int) event.getY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                yDown = y;
                break;
            case MotionEvent.ACTION_MOVE:
                yMove = y;
                if ((yMove - yDown) > 0)
                {
                    //计算每次滑动的距离和总距离，将每次滑动的距离作为layout()方法的参数并重新布局，达到滑动效果
                    mMove = yMove - yDown;
                    i += mMove;
                    layout(getLeft() , getTop() + mMove , getRight() , getBottom() + mMove);
                }
                break;
            case MotionEvent.ACTION_UP:
                //MotionEvent.Action_UP：将滑动的总距离作为layout()方法的参数，重新布局，达到布局回弹的效果
                layout(getLeft() , getTop() - i , getRight() , getBottom() - i);
                i = 0;
                break;
        }
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        int y = (int) ev.getY();
        switch (ev.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                yDown = y;
                isIntercept = false;
                break;
            case MotionEvent.ACTION_MOVE:
                yMove = y;
                if (yMove - yDown < 0)
                {
                    isIntercept = false;
                }
                else if (yMove - yDown > 0)
                {
                    isIntercept = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return isIntercept;
    }
}
