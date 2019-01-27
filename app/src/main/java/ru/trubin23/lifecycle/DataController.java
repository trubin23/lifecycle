package ru.trubin23.lifecycle;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

class DataController {

    private static DataController INSTANCE;

    private MutableLiveData<String> mLiveData = new MutableLiveData<>();

    public static DataController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataController();
        }
        return INSTANCE;
    }

    LiveData<String> getLiveData(){
        return mLiveData;
    }
}
