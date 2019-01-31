package ru.trubin23.lifecycle.fifth_activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Pair;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<Pair<Integer, String>> mMutableLiveData = new MutableLiveData<>();

    public void send(Integer id, String message) {
        mMutableLiveData.setValue(new Pair<>(id, message));
    }

    public LiveData<Pair<Integer, String>> getLiveData() {
        return mMutableLiveData;
    }
}
