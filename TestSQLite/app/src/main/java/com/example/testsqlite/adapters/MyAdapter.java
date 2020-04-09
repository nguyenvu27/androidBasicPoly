package com.example.testsqlite.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testsqlite.R;
import com.example.testsqlite.model.Student;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> arrayList;

    public MyAdapter(Context context, ArrayList<Student> arrayList) {
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
        TextView age = (TextView) convertView.findViewById(R.id.tvAge);

        Student student = arrayList.get(position);

        id.setText(String.valueOf(student.getId()));
        name.setText(student.getName());
        age.setText(student.getAge());

        return convertView;

    }
}
