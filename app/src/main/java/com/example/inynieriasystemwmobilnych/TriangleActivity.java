package com.example.inynieriasystemwmobilnych;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TriangleActivity extends CalcActivity {
    static private Triangle T;

    class Triangle {
        private double a, b, c;

        Triangle(double _a, double _b, double _c) {
            a = _a;
            b = _b;
            c = _c;
        }

        double area() {
            double p = (a + b + c) / 2;
            double w = (p - a) * (p - b) * (p - c) * p;
            return Math.sqrt(w);
        }
    }

    Triangle parse() {
        double a = Double.parseDouble(((EditText) findViewById(R.id.aEditText)).getText().toString());
        double b = Double.parseDouble(((EditText) findViewById(R.id.bEditText)).getText().toString());
        double c = Double.parseDouble(((EditText) findViewById(R.id.cEditText)).getText().toString());
        return new Triangle(a, b, c);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        findViewById(R.id.triangleCaclcButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        hideKeyboard();
                        try {
                            T = parse();
                            if (T.a + T.b > T.c && T.a + T.c > T.b && T.b + T.c > T.a) {
                                ((TextView) findViewById(R.id.resultTextView)).setText(String.valueOf(T.area()));
                            } else {
                                Toast.makeText(TriangleActivity.this, "Zły trójkąt", Toast.LENGTH_LONG).show();
                            }
                        } catch (NumberFormatException e) {
                            Toast.makeText(TriangleActivity.this, "Podaj długości wszystkich boków", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );

        findViewById(R.id.addButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double area_string;
                        try {
                            T = parse();
                            if (T.a + T.b > T.c && T.a + T.c > T.b && T.b + T.c > T.a) {
                                area_string = (T.area());
                                Intent backIntent = new Intent();
                                backIntent.putExtra(RESULT, area_string);
                                setResult(RESULT_OK, backIntent);
                                finish();
                            } else {
                                Toast.makeText(TriangleActivity.this, "Zły trójkąt", Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(TriangleActivity.this, "Podaj długości wszystkich boków", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        findViewById(R.id.backButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent backIntent = new Intent();
                        backIntent.putExtra(RESULT, "0.0");
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }
                }
        );
    }

}


