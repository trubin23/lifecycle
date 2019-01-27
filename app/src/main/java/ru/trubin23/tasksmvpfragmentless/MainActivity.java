package ru.trubin23.tasksmvpfragmentless;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logCurrentState();

        setContentView(R.layout.activity_main);

        MyServer myServer = new MyServer();
        getLifecycle().addObserver(myServer);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logCurrentState();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logCurrentState();
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

        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            Log.d(TAG, "isAtLeast State.STARTED: " + getLifecycle().getCurrentState().name());
        }
    }
}
