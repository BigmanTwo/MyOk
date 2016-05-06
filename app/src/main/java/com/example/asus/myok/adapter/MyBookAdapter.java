package com.example.asus.myok.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.myok.R;
import com.example.asus.myok.bean.Books;

import java.util.List;

/**
 * Created by Asus on 2016/5/5.
 */
public class MyBookAdapter extends BaseAdapter {
    private List<Books> list;
    private Context mContext;

    public MyBookAdapter(List<Books> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.listview_item,null);
            viewHolder.textView=(TextView)convertView.findViewById(R.id.text_item);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position).getTitle());
        return convertView;
    }
    class ViewHolder{
        private TextView textView;
    }
}
