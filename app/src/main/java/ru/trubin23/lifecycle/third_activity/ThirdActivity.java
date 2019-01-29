package ru.trubin23.lifecycle.third_activity;

import android.arch.lifecycle.MediatorLiveData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ru.trubin23.lifecycle.R;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = ThirdActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        MediatorLiveData<String> mediatorLiveData = DataSource.getInstance().getMediatorLiveData();

        mediatorLiveData.observe(this, string -> Log.d(TAG, string));
    }
}
