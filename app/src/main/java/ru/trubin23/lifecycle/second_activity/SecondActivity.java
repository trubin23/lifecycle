package ru.trubin23.lifecycle.second_activity;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ru.trubin23.lifecycle.R;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getLiveDataExtend().observe(this,
                integer -> Log.d(LiveDataExtend.TAG, String.valueOf(integer)));
    }

    private void liveDataIntLogs() {
        LiveData<String> liveData = DataController.getInstance().getLiveData();

        LiveData<Integer> liveDataInt = Transformations.map(liveData, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return Integer.parseInt(input);
            }
        });
        liveDataInt.observe(this, integer ->
                Log.d(TAG, "liveDataInt negative value: " + String.valueOf(-integer)));
    }

    private void liveDataUserLogs() {
        LiveData<String> liveData = DataController.getInstance().getLiveData();

        LiveData<Integer> liveDataInt = Transformations.map(liveData, Integer::parseInt);

        LiveData<User> liveDataUser = Transformations.switchMap(liveDataInt, new Function<Integer, LiveData<User>>() {
            @Override
            public LiveData<User> apply(Integer id) {
                UserController userController = UserController.getInstance();
                userController.setUser(new User(id));
                return userController.getLiveData();
            }
        });

        liveDataUser.observe(this, user ->
                Log.d(TAG, "liveDataUser user: " + user.toString()));
    }

    private LiveDataExtend getLiveDataExtend() {
        return LiveDataExtend.getInstance();
    }
}
