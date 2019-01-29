package ru.trubin23.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import ru.trubin23.lifecycle.first_activity.FirstActivity;
import ru.trubin23.lifecycle.second_activity.SecondActivity;
import ru.trubin23.lifecycle.third_activity.ThirdActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button buttonFirstActivity = findViewById(R.id.button_first_activity);
        buttonFirstActivity.setOnClickListener(v -> {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
        });

        Button buttonSecondActivity = findViewById(R.id.button_second_activity);
        buttonSecondActivity.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });

        Button buttonThirdActivity = findViewById(R.id.button_third_activity);
        buttonThirdActivity.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
        });
    }
}
