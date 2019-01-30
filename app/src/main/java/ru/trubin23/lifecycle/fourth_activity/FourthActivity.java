package ru.trubin23.lifecycle.fourth_activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ru.trubin23.lifecycle.R;

public class FourthActivity extends AppCompatActivity {

    private static final String TAG = FourthActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        LiveData<String> liveData = viewModel.getData();
        liveData.observe(this, result -> Log.d(TAG, result));
    }
}
