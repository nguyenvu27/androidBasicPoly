package com.example.lab3_android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab3_android.R;

public class Bai2Activity extends AppCompatActivity {
    EditText a, b, c;
    Button Tinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.b);

        final Button button = (Button) findViewById(R.id.calculate);

//        final TextView result = (TextView) findViewById(R.id.result);

        button.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Bai2Activity.this, KQActivity.class);
                intent.putExtra("a", a.getText().toString());
                intent.putExtra("b", b.getText().toString());
                intent.putExtra("c", a.getText().toString());
                startActivity(intent);
//                String sa = ((EditText) findViewById(R.id.a)).getText().toString();
//
//                String sb = ((EditText) findViewById(R.id.b)).getText().toString();
//
//                String sc = ((EditText) findViewById(R.id.c)).getText().toString();
//
//
//                try {
//
//                    double a = Double.parseDouble(sa);
//
//                    double b = Double.parseDouble(sb);
//
//                    double c = Double.parseDouble(sc);
//
//
//                    if (a == 0) {
//
//                        result.setText("Phương trình bậc I:");
//
//                        if (b == 0) {
//
//                            if (c == 0)
//
//                                result.setText(result.getText() + "Phương trình có vô số nghiệm ");
//
//                            else
//
//                                result.setText(result.getText() + "Phương trình vô nghiệm");
//
//                        } else {
//
//                            result.setText(result.getText() + "x = " + (-c / b));
//
//                        }
//
//                    } else {
//
//                        double delta = b * b - 4 * a * c;
//
//
//                        if (delta < 0.0) {
//
//                            result.setText("Phương trình vô nghiệm\n");
//
//                        } else if (delta == 0) {
//
//                            result.setText("Phương trình có nghiệm kép = " + (-b / (2 * a)));
//
//                        } else {
//
//                            double delta_sqrt = Math.sqrt(delta);
//
//                            result.setText("x1 = " + ((b * b + delta_sqrt) / (2 * a)) + "\n" + "x2 = " + ((b * b - delta_sqrt) / (2 * a)));
////                            ((b*b – delta_sqrt)/(2 * a)))
//
//                        }
//
//                    }
//
//
//                } catch (Exception ex) {
//
//                    result.setText(ex.toString());
//
//                }
//
            }
//
        });

    }

    public void giaiPT(View view) {
        Intent intent = new Intent(Bai2Activity.this, KQActivity.class);
        intent.putExtra("a", a.getText().toString());
        intent.putExtra("b", b.getText().toString());
        intent.putExtra("c", a.getText().toString());
    }

}

