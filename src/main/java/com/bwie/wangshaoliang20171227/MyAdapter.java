package com.bwie.wangshaoliang20171227;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import static com.bwie.wangshaoliang20171227.R.id.simpl;
import static com.bwie.wangshaoliang20171227.R.id.tv;

/**
 * Created by lenovo on 2017/12/27.
 */

public class MyAdapter extends BaseAdapter{
    private List<Bean> been;
    private Context context;

    public MyAdapter(List<Bean> been, Context context) {
        this.been = been;
        this.context = context;
    }

    @Override
    public int getCount() {
        return been.size();
    }

    @Override
    public Object getItem(int i) {
        return been.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
         view=View.inflate(context,R.layout.item,null);
          view.setTag(viewHolder);  //讲ViewHolder存储在View中
        }else {
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.simpl =(SimpleDraweeView) view.findViewById(simpl);
        viewHolder.tv=(TextView) view.findViewById(tv);
        viewHolder.simpl.setImageURI(been.get(i).getImg());
        RoundingParams params=RoundingParams.asCircle();
        viewHolder.simpl.getHierarchy().setRoundingParams(params);
        viewHolder.tv.setText(been.get(i).getTitle());
        return view;
    }
 class ViewHolder{
    private SimpleDraweeView simpl;
    private TextView tv;
}
}
