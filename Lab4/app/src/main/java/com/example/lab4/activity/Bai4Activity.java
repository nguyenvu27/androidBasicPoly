package com.example.lab4.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab4.R;

public class Bai4Activity extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Peter Jame", "Henry Jacobs", "Bola Olumide", "Chidi Johnson", "DeGordio Puritio", "Gary Cook"};
    String mDescripsion[] = {"Vildansvagen 19, Lund Sweden", "3 Villa Crescent London, UK", "Victoria IsLand Lagos, Nigeria", "New Heaven Enugu, Nigeria", "Itallon Gata, Padova, , Italy", "San Fransisco, United States"};
    int image[] = {R.drawable.businessman, R.drawable.footballplayer, R.drawable.hihi, R.drawable.moustache, R.drawable.businessman, R.drawable.footballplayer};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        listView = findViewById(R.id.listView);

        MyAdapter myAdapter = new MyAdapter(this, mTitle, mDescripsion, image);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Bai4Activity.this, "Peter Jame", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Toast.makeText(Bai4Activity.this, "Henry Jacobs", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(Bai4Activity.this, "Bola Olumide", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(Bai4Activity.this, "Chidi Johnson", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Toast.makeText(Bai4Activity.this, "DeGordio Puritio", Toast.LENGTH_SHORT).show();
                }
                if (position == 5) {
                    Toast.makeText(Bai4Activity.this, "Gary Cook", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImage[];

        MyAdapter(@NonNull Context c, String title[], String description[], int image[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImage = image;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView MyDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            MyDescription.setText(rDescription[position]);
            return row;
        }
    }
}
