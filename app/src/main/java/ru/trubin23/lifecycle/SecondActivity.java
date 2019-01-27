package ru.trubin23.lifecycle;

import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextView = findViewById(R.id.text_view);

        LiveData<String> liveData = DataController.getInstance().getLiveData();

        liveData.observe(this, string -> {
            mTextView.setText(string);
        });
    }
}
