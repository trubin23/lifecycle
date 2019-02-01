package ru.trubin23.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import ru.trubin23.lifecycle.fifth_activity.FifthActivity;
import ru.trubin23.lifecycle.first_activity.FirstActivity;
import ru.trubin23.lifecycle.fourth_activity.FourthActivity;
import ru.trubin23.lifecycle.second_activity.SecondActivity;
import ru.trubin23.lifecycle.third_activity.ThirdActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Map<Integer, Class<?>> activitiesMap = new HashMap<>();
        activitiesMap.put(R.id.button_first_activity, FirstActivity.class);
        activitiesMap.put(R.id.button_second_activity, SecondActivity.class);
        activitiesMap.put(R.id.button_third_activity, ThirdActivity.class);
        activitiesMap.put(R.id.button_fourth_activity, FourthActivity.class);
        activitiesMap.put(R.id.button_fifth_activity, FifthActivity.class);

        for (Map.Entry<Integer, Class<?>> entry : activitiesMap.entrySet()){
            Integer id = entry.getKey();
            Class<?> cls = entry.getValue();

            Button button = findViewById(id);
            button.setOnClickListener(v -> {
                Intent intent = new Intent(this, cls);
                startActivity(intent);
            });
        }
    }
}
