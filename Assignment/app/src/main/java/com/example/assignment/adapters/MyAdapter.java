package com.example.assignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.Student;

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
        convertView = inflater.inflate(R.layout.list, null);
        TextView id = (TextView) convertView.findViewById(R.id.stt);
        TextView malop = (TextView) convertView.findViewById(R.id.maLop);
        TextView tenlop = (TextView) convertView.findViewById(R.id.tenLop);

        Student student = arrayList.get(position);

        id.setText(String.valueOf(student.getId()));
        malop.setText(student.getMalop());
        tenlop.setText(student.getTenlop());

        return convertView;

    }
}
