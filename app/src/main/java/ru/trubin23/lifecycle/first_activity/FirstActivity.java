package ru.trubin23.lifecycle.first_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import ru.trubin23.lifecycle.R;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = FirstActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logCurrentState();

        setContentView(R.layout.activity_first);

        MyServer myServer = new MyServer();
        getLifecycle().addObserver(myServer);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> logCurrentState());
    }

    @Override
    protected void onStart() {
        super.onStart();
        logCurrentState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logCurrentState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        logCurrentState();
    }

    @Override
    protected void onStop() {
        super.onStop();
        logCurrentState();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logCurrentState();
    }

    void logCurrentState() {
        Log.d(TAG, getLifecycle().getCurrentState().name());
    }
}
