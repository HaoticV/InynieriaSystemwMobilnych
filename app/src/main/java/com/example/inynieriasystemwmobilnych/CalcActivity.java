package com.example.inynieriasystemwmobilnych;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

abstract public class CalcActivity extends AppCompatActivity {

    public static final String RESULT = "Area";

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backIntent = new Intent();
        backIntent.putExtra(RESULT, "0.0");
        setResult(RESULT_OK, backIntent);
        finish();
    }

    void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(RectangleActivity.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
