package ru.trubin23.lifecycle;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.Random;

class DataController {

    private static DataController INSTANCE;

    private MutableLiveData<String> mLiveData = new MutableLiveData<>();

    static DataController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataController();

            MutableLiveData<String> liveData = INSTANCE.getMutableLiveData();
            Random rand = new Random();
            int sleepMin = 500, sleepMax = 5000;

            Thread thread = new Thread(() -> {
                while (true) {
                    int sleepRandom = rand.nextInt(sleepMax - sleepMin) + sleepMin;

                    liveData.postValue(String.valueOf(sleepRandom));

                    try {
                        Thread.sleep(sleepRandom);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
        return INSTANCE;
    }

    LiveData<String> getLiveData(){
        return mLiveData;
    }

    private MutableLiveData<String> getMutableLiveData(){
        return mLiveData;
    }
}
