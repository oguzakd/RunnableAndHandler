package com.oguzhanakduman.runnableandhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Runnable runnable;
    Handler handler;
    TextView textView;
    Button startButton;
    Button stopButton;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

    }

    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Timer: " + count);
                count++;
                textView.setText("Timer: " + count);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        startButton.setEnabled(false);
    }

    public void stop(View view){
        startButton.setEnabled(true);
        startButton.removeCallbacks(runnable);
        count = 0;
        textView.setText("Timer: " + count);
    }
}