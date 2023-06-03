package com.toantx.mycppproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'mycppproject' library on application startup.
    static {
        System.loadLibrary("mycppproject");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        TextView returnText = findViewById(R.id.return_text);
        returnText.setText(process());
    }

    public String processInJava() {
        return "30";
    }

    /**
     * A native method that is implemented by the 'mycppproject' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String process();
}