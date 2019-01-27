package ru.trubin23.tasksmvpfragmentless;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyServer myServer = new MyServer();
        getLifecycle().addObserver(myServer);
    }
}
