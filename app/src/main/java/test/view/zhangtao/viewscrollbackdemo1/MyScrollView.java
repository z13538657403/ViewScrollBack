package test.view.zhangtao.viewscrollbackdemo1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by zhangtao on 16/12/6.
 */

public class MyScrollView extends ScrollView
{
    public MyScrollView(Context context)
    {
        this(context , null);
    }

    public MyScrollView(Context context, AttributeSet attrs)
    {
        this(context, attrs , 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        switch (ev.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                //禁止父View进行事件拦截
                getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_MOVE:
                int scrollY = getScrollY();

                if (scrollY == 0)
                {
                    //允许父View进行事件拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                else
                {
                    //禁止父View进行事件拦截
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
        }

        return super.onTouchEvent(ev);
    }
}
