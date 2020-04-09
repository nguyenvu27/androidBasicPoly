package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.activity.ListActivity;
import com.example.assignment.activity.QLSVActivity;
import com.example.assignment.database.DatabaseHelper;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnList, btnQLSV;

    @NotEmpty
    EditText txtMalop, txtTenLop;


    Button btnLuuLop, btnXoaTrang;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnThemLop);
        btnList = findViewById(R.id.btnXemDanhSachLop);
        btnQLSV = findViewById(R.id.btnQuanLySinhVien);

        txtMalop = (EditText) findViewById(R.id.edtMaLop);
        txtTenLop = (EditText) findViewById(R.id.edtTenLop);
        btnLuuLop = findViewById(R.id.btnLuuLop);
        btnXoaTrang = findViewById(R.id.btnXoaTrang);
        databaseHelper = new DatabaseHelper(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final View v2 = getLayoutInflater().inflate(R.layout.dialog, null);
                final EditText ed_maLop = v2.findViewById(R.id.edtMaLop);
                final EditText ed_tenLop = v2.findViewById(R.id.edtTenLop);
                Button btn_them = v2.findViewById(R.id.btnLuuLop);
                Button xoa = v2.findViewById(R.id.btnXoaTrang);
                builder.setView(v2);
                final Dialog dialog = builder.create();
                dialog.show();

                btn_them.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ed_maLop.getText().toString().equals("") || ed_tenLop.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Bạn cần phải điền đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
                        } else {
                            boolean result = databaseHelper.insertData(ed_maLop.getText().toString(), ed_tenLop.getText().toString());
                            if (result) {
                                Toast.makeText(MainActivity.this, "Thêm Thành công.", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();


                            }

                        }
                    }
                });

                xoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ed_maLop.setText("");
                        ed_tenLop.setText("");
                    }
                });

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        btnQLSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QLSVActivity.class);
                startActivity(intent);
            }
        });
    }
}
