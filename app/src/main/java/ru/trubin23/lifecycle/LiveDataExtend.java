package ru.trubin23.lifecycle;

import android.arch.lifecycle.LiveData;
import android.util.Log;

public class LiveDataExtend extends LiveData<Integer> {

    private static LiveDataExtend INSTANCE;

    public static final String TAG = LiveDataExtend.class.getSimpleName();

    private static boolean mActive;

    static LiveDataExtend getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LiveDataExtend();

            Thread thread = new Thread(() -> {
                Integer step = 0;

                while (true) {
                    Log.d(TAG, "step: " + String.valueOf(step));
                    if (mActive){
                        INSTANCE.postValue(step);
                    } else {
                        Log.d(TAG, "inactive");
                    }

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    step++;
                }
            });
            thread.start();
        }
        return INSTANCE;
    }

    @Override
    protected void onActive() {
         mActive = true;
    }

    @Override
    protected void onInactive() {
        mActive = false;
    }
}
