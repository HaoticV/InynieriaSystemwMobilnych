package com.example.inynieriasystemwmobilnych;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity0 extends AppCompatActivity {

    public static final int CODE_TRIANGLE=10;
    private double area=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);
        area=0.0;

        findViewById(R.id.triangleButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent triangleIntent = new Intent(Activity0.this, TriangleActivity.class);
                        startActivityForResult(triangleIntent, CODE_TRIANGLE);

                    }
                }
        );
        findViewById(R.id.rectangleButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Activity0.this, RectangleActivity.class);
                        startActivityForResult(intent, CODE_TRIANGLE);

                    }
                }
        );
        findViewById(R.id.circleButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Activity0.this, CircleActivity.class);
                        startActivityForResult(intent, CODE_TRIANGLE);

                    }
                }
        );
        findViewById(R.id.resetButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        area=0;
                        ((TextView)findViewById(R.id.resultTextView)).setText(String.valueOf(area));
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            Double new_area = data.getDoubleExtra(TriangleActivity.RESULT, 0);
            area += new_area;
            ((TextView) findViewById(R.id.resultTextView)).setText(String.valueOf(area));
        }
    }
}
