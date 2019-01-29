package ru.trubin23.lifecycle.third_activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class MyThread extends Thread {

    private MutableLiveData<String> mMutableLiveData = new MutableLiveData<>();
    private String mDescription;
    private int mSleepTime;

    MyThread(String description, int sleepTime) {
        mDescription = description;
        mSleepTime = sleepTime;
    }

    @Override
    public void run() {
        super.run();

        for (int index = 0; ; index++) {
            mMutableLiveData.postValue(mDescription + " " + String.valueOf(index));

            try {
                Thread.sleep(mSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    LiveData<String> getLiveData() {
        return mMutableLiveData;
    }
}