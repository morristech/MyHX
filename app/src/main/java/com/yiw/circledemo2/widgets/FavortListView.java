package com.yiw.circledemo2.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yiw.circledemo2.adapter.FavortListAdapter;
import com.yiw.circledemo2.spannable.ISpanClick;

/**
 * @author yiw
 * @Description:
 * @date 16/1/2 18:47
 */
public class FavortListView extends TextView{
    private ISpanClick mSpanClickListener;

    public void setSpanClickListener(ISpanClick listener){
        mSpanClickListener = listener;
    }
    public ISpanClick getSpanClickListener(){
        return  mSpanClickListener;
    }

    public FavortListView(Context context) {
        super(context);
    }

    public FavortListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FavortListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAdapter(FavortListAdapter adapter){
        adapter.bindListView(this);
    }

}
