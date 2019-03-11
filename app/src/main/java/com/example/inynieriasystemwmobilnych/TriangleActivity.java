package com.example.inynieriasystemwmobilnych;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TriangleActivity extends AppCompatActivity {
    public static final String RESULT = "";
    private Triangle t;

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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        findViewById(R.id.triangleCaclcButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) throws NumberFormatException {
                        hideKeyboard();
                        try {
                            Double a = Double.parseDouble(((EditText) findViewById(R.id.aEditText)).getText().toString());
                            Double b = Double.parseDouble(((EditText) findViewById(R.id.bEditText)).getText().toString());
                            Double c = Double.parseDouble(((EditText) findViewById(R.id.cEditText)).getText().toString());
                            if (a + b > c && a + c > b && b + c > a) {
                                t = new Triangle(a, b, c);
                                ((TextView) findViewById(R.id.resultTextView)).setText(String.valueOf(t.area()));
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
                        Double area_string=(t.area());
                        Intent backIntent = new Intent();
                        backIntent.putExtra(RESULT, area_string);
                        setResult(RESULT_OK, backIntent);
                        finish();
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

    void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(RectangleActivity.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
