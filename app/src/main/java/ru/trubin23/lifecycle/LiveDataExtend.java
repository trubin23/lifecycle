package ru.trubin23.lifecycle;

import android.arch.lifecycle.LiveData;
import android.util.Log;

public class LiveDataExtend extends LiveData<Integer> {

    public static final String TAG = LiveDataExtend.class.getSimpleName();

    private Thread mThread = new Thread(() -> {
        Integer sleepTime = 10;

        Integer step = 0;

        while (true) {
            Log.d(TAG, "step: " + String.valueOf(step));

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    @Override
    protected void onActive() {

    }

    @Override
    protected void onInactive() {
    }
}
