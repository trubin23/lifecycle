package ru.trubin23.lifecycle.fifth_activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import ru.trubin23.lifecycle.R;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        Map<Integer, Integer> fragmentMap = new HashMap<>();
        fragmentMap.put(1, R.id.first_frame_layout);
        fragmentMap.put(2, R.id.second_frame_layout);
        fragmentMap.put(3, R.id.third_frame_layout);

//        MessengerFragment messengerFragment =
//                (MessengerFragment) getSupportFragmentManager().findFragmentById(R.id.first_frame_layout);
//        if (messengerFragment == null) {
//            messengerFragment = MessengerFragment.newInstance(1);
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.add(R.id.first_frame_layout, messengerFragment);
//            transaction.commit();
//        }
    }
}
