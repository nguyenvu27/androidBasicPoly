package com.example.lab4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab4.R;

class MyAdapter extends ArrayAdapter<String> {
    Context context;
    String rTitle[];
    String rDescription[];
    int rImage[];


    public MyAdapter(@NonNull Context c, String title[], String description[], int image[]  ) {
        super(c, R.layout.row, R.id.textView1, title);
        this.context = c ;
        this.rTitle = title ;
        this.rDescription = description ;
        this.rImage = image ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext()
        return super.getView(position, convertView, parent);
    }
}
