package com.example.assignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.Student;
import com.example.assignment.model.Student2;


import java.util.ArrayList;


public class MyAdapter2 extends BaseAdapter {
    Context context;
    ArrayList<Student2> arrayList;

    public MyAdapter2(Context context, ArrayList<Student2> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item, null);
        TextView id = (TextView) convertView.findViewById(R.id.tvStt);
        TextView name = (TextView) convertView.findViewById(R.id.tvName);
        TextView age = (TextView) convertView.findViewById(R.id.tvDate);

        Student2 student2 = arrayList.get(position);

        id.setText(String.valueOf(student2.getId()));
        name.setText(student2.getName());
        age.setText(student2.getDate());

        return convertView;

    }
}
