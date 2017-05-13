package com.example.user.decaming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 2017-05-13.
 */


public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public ListViewAdapter(){

    }
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        if(convertView ==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem,parent,false);
        }
        TextView text1 = (TextView)convertView.findViewById(R.id.text1);
        TextView text2 = (TextView)convertView.findViewById(R.id.text2);
        TextView text3 = (TextView)convertView.findViewById(R.id.text3);

        ListViewItem listViewItem = listViewItemList.get(position);
        text1.setText(listViewItem.getText1());
        text2.setText(listViewItem.getText2());
        text3.setText(listViewItem.getText3());

        return convertView;
    }
    public void addItem(String text1,String text2,String text3){
        ListViewItem item = new ListViewItem(text1,text2,text3);
        listViewItemList.add(item);
    }
}
